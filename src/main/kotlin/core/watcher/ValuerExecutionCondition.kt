package core.watcher

import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext

class ValuerExecutionCondition : ExecutionCondition {

  override fun evaluateExecutionCondition(context: ExtensionContext?): ConditionEvaluationResult {
    var result: ConditionEvaluationResult = ConditionEvaluationResult.enabled("Method doesn't  marked my annotation")

    when (context?.element?.get()?.isAnnotationPresent(Ban::class.java)) {
      true -> result = ConditionEvaluationResult.disabled("Method marked Ban annotation")
    }
    return result
  }
}