// "Create actual class for module testModule_JS (JS)" "true"

expect sealed class Sealed

expect object Obj : Sealed

expect class <caret>Klass(x: Int) : Sealed
