package extensions

inline fun <T> T?.doWhenNotNull(block: (T) -> Unit) = this.takeIf { it != null }?.let(block)

inline fun <T, R> T?.doAndReturnWhenNotNull(block: (T) -> R) = this.takeIf { it != null }?.let(block)
