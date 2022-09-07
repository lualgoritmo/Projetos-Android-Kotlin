package br.com.zup.frasesaleatorias.data


import br.com.zup.frasesaleatorias.constants.ALL
import br.com.zup.frasesaleatorias.constants.HAPPY
import br.com.zup.frasesaleatorias.constants.SUNNY
import br.com.zup.frasesaleatorias.domain.model.Phrase
import kotlin.random.Random

class Mock {
    private val all = ALL
    private val happy = HAPPY
    private val sunny = SUNNY

    private val phraseMaria = listOf(
        Phrase("Os derrotados são os que desistem, seja um vencedor e persista até atingir o que deseja.",
            sunny),
        Phrase("A dor é resultado do seu esforço. Afinal, nada na vida vem fácil, nem a sua saúde.",
            sunny),
        Phrase("Não importa o que eu sou. O fato é que o nome do filme é ‘Os homens preferem as loiras’, e eu sou a loira.",
            sunny),
        Phrase("Não vou a praia para ficar morena, gosto de ser loira.", sunny),
        Phrase("Eu já fui loira, ruiva, morena… já mudei várias vezes, tanto por fora quanto por dentro. Mas em nenhum momento deixei de ser eu mesma.",
            sunny),
        Phrase("Não sabendo que era impossível, foi lá e fez.", sunny),
        Phrase("Nada acontece de uma hora para outra. A disciplina é que faz seu treino ter resultados.",
            sunny),
        Phrase("Não busque ser melhor que os outros, busque ser melhor que o seu eu de ontem.",
            sunny),
        Phrase("Só você tem o poder de mudar suas escolhas. Escolha treinar com força de vontade e não deixe que nada te impeça.",
            sunny))

    private val phrasesList =
        listOf(
            Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
            Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
            Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
            Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
                happy),
            Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
            Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
                happy),
            Phrase("A melhor maneira de prever o futuro é inventá-lo.", happy),
            Phrase("Você perde todas as chances que você não aproveita.", all),
            Phrase("Fracasso é o condimento que dá sabor ao sucesso.", happy),
            Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", all),
            Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", happy),
            Phrase("Se você acredita, faz toda a diferença.", all),
            Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", happy),
        )

    val getPhrase = fun(value: Int): String {
        val filtered =
            phrasesList.filter { (it.categoryId == value) || (value == all) }
        return filtered[Random.nextInt(filtered.size)].description
//        val index = Random.nextInt(filtered.size)
//        return filtered[index].description
    }
    val getPhraseMaria = fun(value: Int): String {
        val filterMaria = phraseMaria.filter { (it.categoryId == value) || (value == sunny) }
        return filterMaria[Random.nextInt(filterMaria.size)].description
    }
}