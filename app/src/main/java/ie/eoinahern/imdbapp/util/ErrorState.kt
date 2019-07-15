package ie.eoinahern.imdbapp.util

sealed class ErrorState {

    object IOError : ErrorState()
    object NetworkError : ErrorState()

    abstract class CustomErrorState : ErrorState()
}