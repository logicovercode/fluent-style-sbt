package com.logicovercode.base_plugin

import com.logicovercode.bsbt.BuilderStyleBuild
import com.logicovercode.fsbt.commons.dependencies.{AllDependencies, DependencyVersionHandler, GeneratedModuleIds}
import com.logicovercode.fsbt.commons.services.{ClusterServicesProvider, MySqlServiceProvider, PostgresSqlServiceProvider}
import sbt.{AutoPlugin, PluginTrigger, Plugins}

object FluentStyleSbt extends AutoPlugin {

  object autoImport
    extends AllDependencies
      with GeneratedModuleIds
      with MySqlServiceProvider
      with PostgresSqlServiceProvider
      with ClusterServicesProvider
      with FSbtTypeAliases
      with DependencyVersionHandler
      with ClusterServicesHandler

  override def trigger: PluginTrigger = Plugins.noTrigger

  override def requires: Plugins = BuilderStyleBuild

  override lazy val projectSettings = super.projectSettings
}
