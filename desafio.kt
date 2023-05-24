enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Aluno(val nome: String)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val alunosMatriculados = mutableListOf<Aluno>()

    fun matricularAluno(vararg alunos: Aluno) {
        alunosMatriculados.addAll(alunos)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val conteudo3 = ConteudoEducacional("Banco de Dados", 90)
    val conteudo4 = ConteudoEducacional("Integração com o banco de dados",30)

    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    val formacaoJava = Formacao("Formação Java", Nivel.DIFICIL, listOf(conteudo2, conteudo3,conteudo4))

    val aluno1 = Aluno("João Sampaio lima")
    val aluno2 = Aluno("Maria Jose barbosa")
    val aluno3 = Aluno("Pedro Lima Souza")
    val aluno4 = Aluno("Gabriel Simoes Borges")

    formacaoKotlin.matricularAluno(aluno1, aluno2)
    formacaoJava.matricularAluno(aluno2, aluno3 , aluno4)

    println("Alunos matriculados na formação ${formacaoKotlin.nome}:")
    formacaoKotlin.alunosMatriculados.forEach { println(it.nome) }

    println("Alunos matriculados na formação ${formacaoJava.nome}:")
    formacaoJava.alunosMatriculados.forEach { println(it.nome) }
}
