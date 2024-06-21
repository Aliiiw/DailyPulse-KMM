package ir.alirahimi.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform