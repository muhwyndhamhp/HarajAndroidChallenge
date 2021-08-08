package com.example.harajtask.essential.base

data class TaskResult<T>(
    val data: T? = null,
    val error: String? = null,
    val isSuccess: Boolean
) {
    companion object {
        fun <T> success(data: T): TaskResult<T> {
            return TaskResult(data = data, isSuccess = true)
        }

        fun <T> failure(exception: Throwable?): TaskResult<T> {
            return when (exception) {
                null -> TaskResult(error = "", isSuccess = false)
                else -> TaskResult(
                    error = Exception(exception).message?.replace(
                        "java.lang.Throwable: ",
                        ""
                    ),
                    isSuccess = false
                )
            }
        }
    }
}