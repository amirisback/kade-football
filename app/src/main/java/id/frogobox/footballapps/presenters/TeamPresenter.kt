package id.frogobox.footballapps.presenters

import com.google.gson.Gson
import id.frogobox.footballapps.helpers.coroutines.CoroutineContextProvider
import id.frogobox.footballapps.helpers.networks.ApiRepository
import id.frogobox.footballapps.helpers.networks.TheSportDBApi
import id.frogobox.footballapps.helpers.response.TeamResponse
import id.frogobox.footballapps.views.interfaces.TeamView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FootBallApps
 * Copyright (C) 03/12/2018.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */
class TeamPresenter (private val view: TeamView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson,
                     private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    @DelicateCoroutinesApi
    fun getTeamList(leagueName: String?){
        try {
            GlobalScope.launch(context.main) {
                val data = gson.fromJson(
                    apiRepository
                        .doRequest(TheSportDBApi.getAllTeamsByLeagueName(leagueName)).await(), TeamResponse::class.java
                )
                view.hideLoading()
                view.showData(data.teams)
            }
        } catch (e: Exception) {
            view.showLoading()
        }
    }

}