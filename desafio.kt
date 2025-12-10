// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Level {BASICO, INTERMEDIARIO, AVANCADO}

data class User(val name: String)

data class EducationalContent(val name: String, val duration: Int = 60)

data class Training(val name: String, val level: Level, val contents: List<EducationalContent>) {

    val registered = mutableListOf<User>()
    
    fun enroll(user: User) {
        if (!registered.contains(user)) {
            registered.add(user)
            println("Usuário ${user.name} matriculado na formação: $name .")
        } else{
            println("Usuário ${user.name} já está matriculado na formação: $name .")
        }
    }
}

fun main() {
    val kotlinBasic = EducationalContent("Introdução ao kotlin", 45)
    val pookotlin = EducationalContent("POO em kotlin", 60)
    val collectionsKotlin = EducationalContent("Coleções em kotlin", 75)
    
    val trainingKotlin = Training(
        name = "Formação Kotlin Developer",
        level = Level.INTERMEDIARIO,
        contents = listOf(kotlinBasic, pookotlin, collectionsKotlin)
    )
    
    val carlos = User("Carlos")
    val lucas = User("Lucas")
    val renata = User("Renata")
    
    trainingKotlin.enroll(carlos)
    trainingKotlin.enroll(lucas)
    trainingKotlin.enroll(renata)
    trainingKotlin.enroll(carlos) // Test for duplicates
    
    println("Relatório da Formação")
    println("Formação: ${trainingKotlin.name}")
    println("Nível: ${trainingKotlin.level}")
    println("Conteúdos:")
    trainingKotlin.contents.forEach {
        println(" - ${it.name} (${it.duration} min)")
    }
    
    println("Inscritos:")
    trainingKotlin.registered.forEach {
        println(" - ${it.name}")
    }
}
