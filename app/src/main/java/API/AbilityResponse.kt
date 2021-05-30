package API

import liste.Ability


data class AbilityResponse (
    val count: Int,
    val next: String,
    val results: List<Ability>

)
