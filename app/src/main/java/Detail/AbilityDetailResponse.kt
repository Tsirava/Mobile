package Detail

data class AbilityDetailResponse (
    val effect_entries :List<AbilityEffect>
        )

data class AbilityEffect (
    val effect: String,
    val short_effect: String
)
