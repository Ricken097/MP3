package com.example.harsh.mp3;

/**
 * Created by bhaVYa on 29/03/17.
 */

public class PlayerPersonalDetailsDB {
    public String country;
    public String imageURL;
    public String profile;
    public String bowlingStyle;
    public String battingStyle;
    public String majorTeams;
    public String currentAge;
    public String born;
    public String name;

    public String fifties;
    public String hundreds;
    public String stumping;
    public String catches;
    public String sixes;
    public String fours;
    public String sr;
    public String ballfaced;
    public String avg;
    public String highest;
    public String runs;
    public String notout;
    public String innings;
    public String matches;

    public String tens;
    public String fives;
    public String foursb;
    public String srate;
    public String economy;
    public String avgb;
    public String bbm;
    public String bbi;
    public String wickets;
    public String runsb;
    public String ballsb;
    public String inningsb;
    public String matchesb;

    public PlayerPersonalDetailsDB(String country, String imageURL, String profile, String bowlingStyle, String battingStyle, String majorTeams, String currentAge, String born, String name) {
        this.country = country;
        this.imageURL = imageURL;
        this.profile = profile;
        this.bowlingStyle = bowlingStyle;
        this.battingStyle = battingStyle;
        this.majorTeams = majorTeams;
        this.currentAge = currentAge;
        this.born = born;
        this.name = name;
    }

    public PlayerPersonalDetailsDB(String fiftiestests, String hundredstests, String stumpingtests, String catchestests, String sixestests, String fourstests, String srtests, String ballstests, String avgtests, String hstests, String runstests, String notouttests, String inningstests, String matchestests) {
        this.fifties = fiftiestests;
        this.hundreds = hundredstests;
        this.stumping = stumpingtests;
        this.catches = catchestests;
        this.sixes = sixestests;
        this.fours = fourstests;
        this.sr = srtests;
        this.ballfaced = ballstests;
        this.avg = avgtests;
        this.highest = hstests;
        this.runs = runstests;
        this.notout = notouttests;
        this.innings = inningstests;
        this.matches = matchestests;
    }

    public PlayerPersonalDetailsDB(String tenWicketstests, String fiveWicketstests, String fourWicketstests, String sratetests, String economytests, String avgbtests, String bbmtests, String bbitests, String wicketstests, String runsbtests, String ballsbtests, String inningsbtests, String matchesbtests) {
        this.tens = tenWicketstests;
        this.fives = fiveWicketstests;
        this.foursb = fourWicketstests;
        this.srate = sratetests;
        this.economy = economytests;
        this.avgb = avgbtests;
        this.bbm = bbmtests;
        this.bbi = bbitests;
        this.wickets = wicketstests;
        this.runsb = runsbtests;
        this.ballsb = ballsbtests;
        this.inningsb = inningsbtests;
        this.matchesb = matchesbtests;
    }
}
