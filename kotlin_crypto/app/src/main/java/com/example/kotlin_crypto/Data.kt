package com.example.kotlin_crypto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attacks_recorded")
    val attacksRecorded: Int,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("avg_potential")
    val avgPotential: Double,
    @SerializedName("awayGoalCount")
    val awayGoalCount: Int,
    @SerializedName("awayGoals")
    val awayGoals: List<String>,
    @SerializedName("awayID")
    val awayID: Int,
    @SerializedName("away_image")
    val awayImage: String,
    @SerializedName("away_name")
    val awayName: String,
    @SerializedName("away_ppg")
    val awayPpg: Double,
    @SerializedName("away_url")
    val awayUrl: String,
    @SerializedName("btts")
    val btts: Boolean,
    @SerializedName("btts_2hg_potential")
    val btts2hgPotential: Int,
    @SerializedName("btts_fhg_potential")
    val bttsFhgPotential: Int,
    @SerializedName("btts_potential")
    val bttsPotential: Int,
    @SerializedName("card_timings_recorded")
    val cardTimingsRecorded: Int,
    @SerializedName("cards_potential")
    val cardsPotential: Double,
    @SerializedName("coach_a_ID")
    val coachAID: Int,
    @SerializedName("coach_b_ID")
    val coachBID: Int,
    @SerializedName("competition_id")
    val competitionId: Int,
    @SerializedName("corner_2h_count")
    val corner2hCount: Int,
    @SerializedName("corner_fh_count")
    val cornerFhCount: Int,
    @SerializedName("corner_timings_recorded")
    val cornerTimingsRecorded: Int,
    @SerializedName("corners_o105_potential")
    val cornersO105Potential: Int,
    @SerializedName("corners_o85_potential")
    val cornersO85Potential: Int,
    @SerializedName("corners_o95_potential")
    val cornersO95Potential: Int,
    @SerializedName("corners_potential")
    val cornersPotential: Double,
    @SerializedName("date_unix")
    val dateUnix: Int,
    @SerializedName("freekicks_recorded")
    val freekicksRecorded: Int,
    @SerializedName("game_week")
    val gameWeek: Int,
    @SerializedName("GoalCount_2hg")
    val goalCount2hg: Int,
    @SerializedName("goalTimingDisabled")
    val goalTimingDisabled: Int,
    @SerializedName("goal_timings_recorded")
    val goalTimingsRecorded: Int,
    @SerializedName("goalkicks_recorded")
    val goalkicksRecorded: Int,
    @SerializedName("goals_2hg_team_a")
    val goals2hgTeamA: Int,
    @SerializedName("goals_2hg_team_b")
    val goals2hgTeamB: Int,
    @SerializedName("HTGoalCount")
    val hTGoalCount: Int,
    @SerializedName("homeGoalCount")
    val homeGoalCount: Int,
    @SerializedName("homeGoals")
    val homeGoals: List<String>,
    @SerializedName("homeID")
    val homeID: Int,
    @SerializedName("home_image")
    val homeImage: String,
    @SerializedName("home_name")
    val homeName: String,
    @SerializedName("home_ppg")
    val homePpg: Double,
    @SerializedName("home_url")
    val homeUrl: String,
    @SerializedName("ht_goals_team_a")
    val htGoalsTeamA: Int,
    @SerializedName("ht_goals_team_b")
    val htGoalsTeamB: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("match_url")
    val matchUrl: String,
    @SerializedName("matches_completed_minimum")
    val matchesCompletedMinimum: Int,
    @SerializedName("no_home_away")
    val noHomeAway: Int,
    @SerializedName("o05_2H_potential")
    val o052HPotential: Int,
    @SerializedName("o05HT_potential")
    val o05HTPotential: Int,
    @SerializedName("o05_potential")
    val o05Potential: Int,
    @SerializedName("o15_2H_potential")
    val o152HPotential: Int,
    @SerializedName("o15HT_potential")
    val o15HTPotential: Int,
    @SerializedName("o15_potential")
    val o15Potential: Int,
    @SerializedName("o25_potential")
    val o25Potential: Int,
    @SerializedName("o35_potential")
    val o35Potential: Int,
    @SerializedName("o45_potential")
    val o45Potential: Int,
    @SerializedName("odds_1st_half_over05")
    val odds1stHalfOver05: Double,
    @SerializedName("odds_1st_half_over15")
    val odds1stHalfOver15: Double,
    @SerializedName("odds_1st_half_over25")
    val odds1stHalfOver25: Double,
    @SerializedName("odds_1st_half_over35")
    val odds1stHalfOver35: Int,
    @SerializedName("odds_1st_half_result_1")
    val odds1stHalfResult1: Double,
    @SerializedName("odds_1st_half_result_2")
    val odds1stHalfResult2: Double,
    @SerializedName("odds_1st_half_result_x")
    val odds1stHalfResultX: Double,
    @SerializedName("odds_1st_half_under05")
    val odds1stHalfUnder05: Double,
    @SerializedName("odds_1st_half_under15")
    val odds1stHalfUnder15: Double,
    @SerializedName("odds_1st_half_under25")
    val odds1stHalfUnder25: Double,
    @SerializedName("odds_1st_half_under35")
    val odds1stHalfUnder35: Double,
    @SerializedName("odds_2nd_half_over05")
    val odds2ndHalfOver05: Double,
    @SerializedName("odds_2nd_half_over15")
    val odds2ndHalfOver15: Double,
    @SerializedName("odds_2nd_half_over25")
    val odds2ndHalfOver25: Double,
    @SerializedName("odds_2nd_half_over35")
    val odds2ndHalfOver35: Double,
    @SerializedName("odds_2nd_half_result_1")
    val odds2ndHalfResult1: Double,
    @SerializedName("odds_2nd_half_result_2")
    val odds2ndHalfResult2: Double,
    @SerializedName("odds_2nd_half_result_x")
    val odds2ndHalfResultX: Double,
    @SerializedName("odds_2nd_half_under05")
    val odds2ndHalfUnder05: Double,
    @SerializedName("odds_2nd_half_under15")
    val odds2ndHalfUnder15: Double,
    @SerializedName("odds_2nd_half_under25")
    val odds2ndHalfUnder25: Double,
    @SerializedName("odds_2nd_half_under35")
    val odds2ndHalfUnder35: Double,
    @SerializedName("odds_btts_1st_half_no")
    val oddsBtts1stHalfNo: Int,
    @SerializedName("odds_btts_1st_half_yes")
    val oddsBtts1stHalfYes: Int,
    @SerializedName("odds_btts_2nd_half_no")
    val oddsBtts2ndHalfNo: Int,
    @SerializedName("odds_btts_2nd_half_yes")
    val oddsBtts2ndHalfYes: Int,
    @SerializedName("odds_btts_no")
    val oddsBttsNo: Double,
    @SerializedName("odds_btts_yes")
    val oddsBttsYes: Double,
    @SerializedName("odds_corners_1")
    val oddsCorners1: Double,
    @SerializedName("odds_corners_2")
    val oddsCorners2: Double,
    @SerializedName("odds_corners_over_105")
    val oddsCornersOver105: Double,
    @SerializedName("odds_corners_over_115")
    val oddsCornersOver115: Double,
    @SerializedName("odds_corners_over_75")
    val oddsCornersOver75: Double,
    @SerializedName("odds_corners_over_85")
    val oddsCornersOver85: Double,
    @SerializedName("odds_corners_over_95")
    val oddsCornersOver95: Double,
    @SerializedName("odds_corners_under_105")
    val oddsCornersUnder105: Double,
    @SerializedName("odds_corners_under_115")
    val oddsCornersUnder115: Double,
    @SerializedName("odds_corners_under_75")
    val oddsCornersUnder75: Double,
    @SerializedName("odds_corners_under_85")
    val oddsCornersUnder85: Double,
    @SerializedName("odds_corners_under_95")
    val oddsCornersUnder95: Double,
    @SerializedName("odds_corners_x")
    val oddsCornersX: Double,
    @SerializedName("odds_dnb_1")
    val oddsDnb1: Int,
    @SerializedName("odds_dnb_2")
    val oddsDnb2: Int,
    @SerializedName("odds_doublechance_12")
    val oddsDoublechance12: Double,
    @SerializedName("odds_doublechance_1x")
    val oddsDoublechance1x: Double,
    @SerializedName("odds_doublechance_x2")
    val oddsDoublechanceX2: Double,
    @SerializedName("odds_ft_1")
    val oddsFt1: Double,
    @SerializedName("odds_ft_2")
    val oddsFt2: Double,
    @SerializedName("odds_ft_over05")
    val oddsFtOver05: Double,
    @SerializedName("odds_ft_over15")
    val oddsFtOver15: Double,
    @SerializedName("odds_ft_over25")
    val oddsFtOver25: Double,
    @SerializedName("odds_ft_over35")
    val oddsFtOver35: Double,
    @SerializedName("odds_ft_over45")
    val oddsFtOver45: Double,
    @SerializedName("odds_ft_under05")
    val oddsFtUnder05: Double,
    @SerializedName("odds_ft_under15")
    val oddsFtUnder15: Double,
    @SerializedName("odds_ft_under25")
    val oddsFtUnder25: Double,
    @SerializedName("odds_ft_under35")
    val oddsFtUnder35: Double,
    @SerializedName("odds_ft_under45")
    val oddsFtUnder45: Double,
    @SerializedName("odds_ft_x")
    val oddsFtX: Double,
    @SerializedName("odds_team_a_cs_no")
    val oddsTeamACsNo: Double,
    @SerializedName("odds_team_a_cs_yes")
    val oddsTeamACsYes: Double,
    @SerializedName("odds_team_b_cs_no")
    val oddsTeamBCsNo: Double,
    @SerializedName("odds_team_b_cs_yes")
    val oddsTeamBCsYes: Double,
    @SerializedName("odds_team_to_score_first_1")
    val oddsTeamToScoreFirst1: Double,
    @SerializedName("odds_team_to_score_first_2")
    val oddsTeamToScoreFirst2: Double,
    @SerializedName("odds_team_to_score_first_x")
    val oddsTeamToScoreFirstX: Double,
    @SerializedName("odds_win_to_nil_1")
    val oddsWinToNil1: Double,
    @SerializedName("odds_win_to_nil_2")
    val oddsWinToNil2: Double,
    @SerializedName("offsides_potential")
    val offsidesPotential: Double,
    @SerializedName("over05")
    val over05: Boolean,
    @SerializedName("over15")
    val over15: Boolean,
    @SerializedName("over25")
    val over25: Boolean,
    @SerializedName("over35")
    val over35: Boolean,
    @SerializedName("over45")
    val over45: Boolean,
    @SerializedName("over55")
    val over55: Boolean,
    @SerializedName("overallGoalCount")
    val overallGoalCount: Int,
    @SerializedName("pens_recorded")
    val pensRecorded: Int,
    @SerializedName("pre_match_away_ppg")
    val preMatchAwayPpg: Double,
    @SerializedName("pre_match_home_ppg")
    val preMatchHomePpg: Double,
    @SerializedName("pre_match_teamA_overall_ppg")
    val preMatchTeamAOverallPpg: Double,
    @SerializedName("pre_match_teamB_overall_ppg")
    val preMatchTeamBOverallPpg: Double,
    @SerializedName("refereeID")
    val refereeID: Int,
    @SerializedName("revised_game_week")
    val revisedGameWeek: Int,
    @SerializedName("roundID")
    val roundID: Int,
    @SerializedName("season")
    val season: String,
    @SerializedName("stadium_location")
    val stadiumLocation: String,
    @SerializedName("stadium_name")
    val stadiumName: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("team_a_0_10_min_goals")
    val teamA010MinGoals: Int,
    @SerializedName("team_a_2h_cards")
    val teamA2hCards: Int,
    @SerializedName("team_a_2h_corners")
    val teamA2hCorners: Int,
    @SerializedName("team_a_attacks")
    val teamAAttacks: Int,
    @SerializedName("team_a_cards_0_10_min")
    val teamACards010Min: Int,
    @SerializedName("team_a_cards_num")
    val teamACardsNum: Int,
    @SerializedName("team_a_corners")
    val teamACorners: Int,
    @SerializedName("team_a_corners_0_10_min")
    val teamACorners010Min: Int,
    @SerializedName("team_a_dangerous_attacks")
    val teamADangerousAttacks: Int,
    @SerializedName("team_a_fh_cards")
    val teamAFhCards: Int,
    @SerializedName("team_a_fh_corners")
    val teamAFhCorners: Int,
    @SerializedName("team_a_fouls")
    val teamAFouls: Int,
    @SerializedName("team_a_freekicks")
    val teamAFreekicks: Int,
    @SerializedName("team_a_goalkicks")
    val teamAGoalkicks: Int,
    @SerializedName("team_a_offsides")
    val teamAOffsides: Int,
    @SerializedName("team_a_penalties_won")
    val teamAPenaltiesWon: Int,
    @SerializedName("team_a_penalty_goals")
    val teamAPenaltyGoals: Int,
    @SerializedName("team_a_penalty_missed")
    val teamAPenaltyMissed: Int,
    @SerializedName("team_a_possession")
    val teamAPossession: Int,
    @SerializedName("team_a_red_cards")
    val teamARedCards: Int,
    @SerializedName("team_a_shots")
    val teamAShots: Int,
    @SerializedName("team_a_shotsOffTarget")
    val teamAShotsOffTarget: Int,
    @SerializedName("team_a_shotsOnTarget")
    val teamAShotsOnTarget: Int,
    @SerializedName("team_a_throwins")
    val teamAThrowins: Int,
    @SerializedName("team_a_xg")
    val teamAXg: Double,
    @SerializedName("team_a_xg_prematch")
    val teamAXgPrematch: Double,
    @SerializedName("team_a_yellow_cards")
    val teamAYellowCards: Int,
    @SerializedName("team_b_0_10_min_goals")
    val teamB010MinGoals: Int,
    @SerializedName("team_b_2h_cards")
    val teamB2hCards: Int,
    @SerializedName("team_b_2h_corners")
    val teamB2hCorners: Int,
    @SerializedName("team_b_attacks")
    val teamBAttacks: Int,
    @SerializedName("team_b_cards_0_10_min")
    val teamBCards010Min: Int,
    @SerializedName("team_b_cards_num")
    val teamBCardsNum: Int,
    @SerializedName("team_b_corners")
    val teamBCorners: Int,
    @SerializedName("team_b_corners_0_10_min")
    val teamBCorners010Min: Int,
    @SerializedName("team_b_dangerous_attacks")
    val teamBDangerousAttacks: Int,
    @SerializedName("team_b_fh_cards")
    val teamBFhCards: Int,
    @SerializedName("team_b_fh_corners")
    val teamBFhCorners: Int,
    @SerializedName("team_b_fouls")
    val teamBFouls: Int,
    @SerializedName("team_b_freekicks")
    val teamBFreekicks: Int,
    @SerializedName("team_b_goalkicks")
    val teamBGoalkicks: Int,
    @SerializedName("team_b_offsides")
    val teamBOffsides: Int,
    @SerializedName("team_b_penalties_won")
    val teamBPenaltiesWon: Int,
    @SerializedName("team_b_penalty_goals")
    val teamBPenaltyGoals: Int,
    @SerializedName("team_b_penalty_missed")
    val teamBPenaltyMissed: Int,
    @SerializedName("team_b_possession")
    val teamBPossession: Int,
    @SerializedName("team_b_red_cards")
    val teamBRedCards: Int,
    @SerializedName("team_b_shots")
    val teamBShots: Int,
    @SerializedName("team_b_shotsOffTarget")
    val teamBShotsOffTarget: Int,
    @SerializedName("team_b_shotsOnTarget")
    val teamBShotsOnTarget: Int,
    @SerializedName("team_b_throwins")
    val teamBThrowins: Int,
    @SerializedName("team_b_xg")
    val teamBXg: Double,
    @SerializedName("team_b_xg_prematch")
    val teamBXgPrematch: Double,
    @SerializedName("team_b_yellow_cards")
    val teamBYellowCards: Int,
    @SerializedName("throwins_recorded")
    val throwinsRecorded: Int,
    @SerializedName("total_2h_cards")
    val total2hCards: Int,
    @SerializedName("totalCornerCount")
    val totalCornerCount: Int,
    @SerializedName("total_fh_cards")
    val totalFhCards: Int,
    @SerializedName("totalGoalCount")
    val totalGoalCount: Int,
    @SerializedName("total_xg")
    val totalXg: Double,
    @SerializedName("total_xg_prematch")
    val totalXgPrematch: Double,
    @SerializedName("u05_potential")
    val u05Potential: Int,
    @SerializedName("u15_potential")
    val u15Potential: Int,
    @SerializedName("u25_potential")
    val u25Potential: Int,
    @SerializedName("u35_potential")
    val u35Potential: Int,
    @SerializedName("u45_potential")
    val u45Potential: Int,
    @SerializedName("winningTeam")
    val winningTeam: Int
)