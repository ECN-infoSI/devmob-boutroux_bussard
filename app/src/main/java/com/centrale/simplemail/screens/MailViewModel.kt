package com.centrale.simplemail.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * [MailViewModel] holds information about a mail.
 * It also has methods that can modify its state depending on the route we are taking.
 */
class MailViewModel : ViewModel() {

    /**
     * Mail state for this order
     */
    private val _uiState =
        MutableStateFlow(com.centrale.simplemail.data.MailUiState())
    val uiState: StateFlow<com.centrale.simplemail.data.MailUiState> = _uiState.asStateFlow()

    /**
     * Set the expediteur
     */
    fun setExpediteur(expediteur: String) {
        _uiState.update { currentState ->
            currentState.copy(
                expediteur = expediteur
            )
        }
    }

    /**
     * Set the destinataire
     */
    fun setDestinataire(destinataire: String) {
        _uiState.update { currentState ->
            currentState.copy(
                destinataire = destinataire
            )
        }
    }

    /**
     * Set the objet
     */
    fun setObjet(objet: String) {
        _uiState.update { currentState ->
            currentState.copy(
                objet = objet
            )
        }
    }

    /**
     * Set the contenu
     */
    fun setContenu(contenu: String) {
        _uiState.update { currentState ->
            currentState.copy(
                contenu = contenu
            )
        }
    }

    /**
     * Set the [currentDate] for this mail
     */
    fun setDate(currentDate: String) {
        _uiState.update { currentState ->
            currentState.copy(
                date = currentDate
            )
        }
    }

    /**
     * Reset the mail state
     */
    fun resetMail() {
        _uiState.value = com.centrale.simplemail.data.MailUiState()
    }

    /**
     * Prepares the state to reply to the sender of the mail.
     * Adding RE : in front of the object.
     * Adding a separation between the old mail and the new mail.
     */
    fun prepareReply(){
        val exp = _uiState.value.expediteur
        val dest = _uiState.value.destinataire
        setExpediteur(dest)
        setDestinataire(exp)
        val obj = _uiState.value.objet
        setObjet("RE : ${obj}")
        val cont = _uiState.value.contenu
        setContenu("$cont\n\n" + "\u2550".repeat(20) + "\n")
    }

    /**
     * Returns the current date
     */
//    private fun currentDate(): String {
//        var date = String
//        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
//        // add current date and the following 3 dates.
//        date = formatter.format(calendar.time)
//        return date
//    }
}