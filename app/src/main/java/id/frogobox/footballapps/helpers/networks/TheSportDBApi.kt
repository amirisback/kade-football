package id.frogobox.footballapps.helpers.networks

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
object TheSportDBApi {

    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"

    fun getEventLeagueById(listApi: String?, leagueId: String?): String {
        return "$BASE_URL$listApi?id=${leagueId.toString()}"
    }

    fun getEventDetailById(eventId: String?): String {
        return "${BASE_URL}lookupevent.php?id=${eventId.toString()}"
    }

    fun getTeamDetailById(teamId: String?): String {
        return "${BASE_URL}lookupteam.php?id=${teamId.toString()}"
    }

    fun getAllTeamsByLeagueName(leagueName: String?): String {
        return "${BASE_URL}search_all_teams.php?l=${leagueName.toString()}"
    }

    fun getAllPlayerFromid(teamId: String?): String{
        return "${BASE_URL}lookup_all_players.php?id=${teamId.toString()}"
    }

    fun getTeamsSearch(team: String?): String {
        return "${BASE_URL}searchteams.php?t=${team.toString()}"
    }

    fun getEventsSearch(event: String?): String {
        return "${BASE_URL}searchevents.php?e=${event.toString()}"
    }
}