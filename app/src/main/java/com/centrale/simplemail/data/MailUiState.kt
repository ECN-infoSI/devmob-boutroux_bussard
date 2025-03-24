package com.centrale.simplemail.data

/**
 * Data class that represents the current mail UI state in terms of [expediteur], [destinataire],
 * [objet], [contenu], [date]. 
 */
data class MailUiState(
    /** Expediteur */
    val expediteur: String = "",
    /** Destinataire */
    val destinataire: String = "",
    /** Objet */
    val objet: String = "",
    /** Contenu */
    val contenu: String = "",
    /** Date de l'envoi du mail */
    val date: String = "",
)
