package com.logicovercode.base_plugin

import com.logicovercode.bsbt.BuilderStyleBuild
import com.logicovercode.bsbt.build.JavaOutputVersions
import com.logicovercode.bsbt.docker.PublicDockerSettings
import com.logicovercode.fsbt.commons.dependencies.{AllDependencies, DependencyVersionHandler, GeneratedModuleIds}
import com.logicovercode.fsbt.commons.services.{DockerCoreExtensions, MicroServicesProvider, MySqlServiceProvider, PostgresSqlServiceProvider}
import sbinary.JavaOutput
import sbt.{AutoPlugin, PluginTrigger, Plugins}

object FluentStyleSbt extends AutoPlugin {

  object autoImport
    extends AllDependencies
      with GeneratedModuleIds
      with MySqlServiceProvider
      with PostgresSqlServiceProvider
      with MicroServicesProvider
      with FSbtTypeAliases
      with DependencyVersionHandler
      with MicroServicesHandler
      with DockerCoreExtensions
      with PublicDockerSettings
      with JavaOutputVersions

  override def trigger: PluginTrigger = Plugins.noTrigger

  override def requires: Plugins = BuilderStyleBuild

  override lazy val projectSettings = super.projectSettings
}
