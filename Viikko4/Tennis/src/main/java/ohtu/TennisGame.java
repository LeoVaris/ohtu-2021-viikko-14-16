package ohtu;

public class TennisGame {
    
    private int playerOne = 0;
    private int playerTwo = 0;
    private String player1Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            playerOne += 1;
        else
            playerTwo += 1;
    }

    public String getEqualScore(int points) {
        switch (points)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public String getAdvantageScore(int p1, int p2) {
        int difference = p1 - p2;
        if (difference == 1) return "Advantage player1";
        else if (difference == -1) return "Advantage player2";
        else if (difference >= 2) return "Win for player1";
        else return "Win for player2";
    }

    public String getScore(int p) {
        switch (p)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }

    public String getScore() {
        if (playerOne == playerTwo)
        {
            return getEqualScore(playerOne);
        }
        else if (playerOne >= 4 || playerTwo >= 4)
        {
            return getAdvantageScore(playerOne, playerTwo);
        }
        else
        {
            return getScore(playerOne) + "-" + getScore(playerTwo);
            /*for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = playerOne;
                else { score+="-"; tempScore = playerTwo;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }*/
        }
    }
}