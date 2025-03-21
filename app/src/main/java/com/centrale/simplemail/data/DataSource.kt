/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.centrale.simplemail.data

import com.centrale.simplemail.R

object DataSource {
    object Routes {
        const val route_app_name = "simple_mail"
        const val route_page_envoyer_mail = "ecriture_screen"
        const val route_parametres = "settings_screen"
        const val route_retour = "previous_screen"
        const val route_joindre = "join_screen"
        const val route_envoyer = "send_screen"
        const val route_repondre = "reply_screen"
        const val route_supprimer = "delete_screen"
        const val route_revenir_liste_mail = "liste_mails_screen"
        const val lecture = "lecture_screen"
    }
//    val flavors = listOf(
//        R.string.vanilla,
//        R.string.chocolate,
//        R.string.red_velvet,
//        R.string.salted_caramel,
//        R.string.coffee
//    )
//
//    val quantityOptions = listOf(
//        Pair(R.string.one_cupcake, 1),
//        Pair(R.string.six_cupcakes, 6),
//        Pair(R.string.twelve_cupcakes, 12)
//    )
}
