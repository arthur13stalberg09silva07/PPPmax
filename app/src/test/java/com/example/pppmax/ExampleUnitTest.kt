package com.example.pppmax

import com.example.pppmax.data.repository.MovieRepositoryImpl
import com.example.pppmax.domain.model.Movie
import com.example.teste2api.MovieApi
import com.example.teste2api.MovieResponse
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
   fun `MovieRepositoryImpl getMovie retorna um objeto do tipo movie`() = runBlocking {
        val movie = Movie(
            id = "111",
            title = "Scarface",
            overview = "Após receber residência permanente nos Estados Unidos em troca do assassinato de um oficial do governo cubano, Tony Montana se torna o chefe do tráfico de drogas em Miami. Matando qualquer um que entre em seu caminho, Tony eventualmente se torna o maior traficante da Florída, controlando quase toda a cocaína que entra em Miami.Porém, a pressão da polícia, as guerras com cartéis colombianos e sua própia paranoia servem para alimentar as chamas de sua eventual queda.",
            backdrop_path = "foto"
            )
        val api: MovieApi= mockk()
        coEvery { api.getMovie("Scarface") } coAnswers {MovieResponse( listOf<Movie>(Movie(
            id="111",
            title="Scarface",
            overview = "Após receber residência permanente nos Estados Unidos em troca do assassinato de um oficial do governo cubano, Tony Montana se torna o chefe do tráfico de drogas em Miami. Matando qualquer um que entre em seu caminho, Tony eventualmente se torna o maior traficante da Florída, controlando quase toda a cocaína que entra em Miami.Porém, a pressão da polícia, as guerras com cartéis colombianos e sua própia paranoia servem para alimentar as chamas de sua eventual queda.",
            backdrop_path = "foto"
        )))
        }
        println(MovieRepositoryImpl(api).getMovieById("111"))
        assertEquals(MovieRepositoryImpl(api).getMovieById("111").first(), movie)
    }
}
