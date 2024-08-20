package com.example.ksp

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*

class AutoKLoggerProcessor : SymbolProcessorProvider {
  override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
    return AutoKLoggerSymbolProcessor(environment)
  }
}

class AutoKLoggerSymbolProcessor(
  private val environment: SymbolProcessorEnvironment
) : SymbolProcessor {

  override fun process(resolver: Resolver): List<KSAnnotated> {
    val symbols = resolver.getSymbolsWithAnnotation(AutoKLogger::class.qualifiedName!!)

    symbols.filterIsInstance<KSClassDeclaration>().forEach { classDeclaration ->
      generateLoggerForClass(classDeclaration)
    }

    return emptyList()
  }

  private fun generateLoggerForClass(classDeclaration: KSClassDeclaration) {
    val className = classDeclaration.simpleName.asString()
    val packageName = classDeclaration.packageName.asString()

    val file = environment.codeGenerator.createNewFile(
      Dependencies(false),
      packageName,
      className
    )

    println("generate auth logger - packageName: $packageName")
    println("generate auth logger - className: $packageName")

    file.bufferedWriter().use { writer ->
      writer.write(
        """
                package $packageName
                
                import io.github.oshai.kotlinlogging.KLogger
                import io.github.oshai.kotlinlogging.KotlinLogging

                class ${className}_Logger {
                    companion object {
                        val logger: KLogger = KotlinLogging.logger("$packageName.$className")
                    }
                }
                """.trimIndent()
      )
    }
  }
}
