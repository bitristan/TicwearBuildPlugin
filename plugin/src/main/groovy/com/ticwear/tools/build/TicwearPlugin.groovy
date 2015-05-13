package com.ticwear.tools.build

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.Task

class TicwearPlugin implements Plugin<Project> {
    final APP_GOOGLE = "com.google.android.wearable.beta.app"
    final APP_TICWEAR = "com.mobvoi.ticwear.app"
    final TASK_PREFIX = "handle"
    final TASK_SUFFIX = "ReleaseMicroApk"
    final ENCODING = "UTF-8"

    void apply(Project project) {
        project.gradle.taskGraph.afterTask { Task task ->
            def name = task.name
            if (name.startsWith(TASK_PREFIX) && name.endsWith(TASK_SUFFIX)) {
                def flavor = getFlavorByTask(name)
                def manifest = getManifestByFlavor(project, flavor)
                postHandleMicroApk(manifest)
            }
        }
    }

    String getManifestByFlavor(Project project, String flavor) {
        flavor = flavor?.trim() ? '/' + flavor.toLowerCase() : ''
        return project.buildDir.absolutePath + '/intermediates/generated/manifests/microapk' + flavor + '/release/AndroidManifest.xml'
    }

    String getFlavorByTask(String name) {
        def matcher = name =~ /$TASK_PREFIX(.*)$TASK_SUFFIX/
        if (matcher.matches()) {
            return matcher[0][1]
        }
        return ""
    }

    void postHandleMicroApk(String manifest) {
        def f = new File(manifest)
        def content = f.getText(ENCODING);
        content = content.replaceAll(/(<application>)(\n)([\s\S]*)(<meta-data[\s\S]*\/>)([\s\S]*<\/application>)/) { full, first, second, third, fourth, five ->
          second = second + third + fourth.replace(APP_GOOGLE, APP_TICWEAR) + second;
          "$first$second$third$fourth$five"
        }
        f.write(content, ENCODING)
    }
}
