class Mafiaplayer {
    private String nickname;
    private int dopes;
    private String side;
    private String status;
    private String experiencelevel;

    public Mafiaplayer() {
        this.nickname = "Cattleya";
        this.dopes = 9;
        this.side = "Mafia";
        this.status = "Don";
        this.experiencelevel= "2";
    }

    public Mafiaplayer(String nickname, int dopes, String side, String status, String experiencelevel) {
        this.nickname = nickname;
        this.dopes = dopes;
        this.side = side;
        this.status = status;
        this.experiencelevel= experiencelevel;
    }


    public String getNickname() { return nickname; }
    public int getdopes() { return dopes; }
    public String getSide() { return side; }
    public String getStatus() { return status; }
    public String getExperiencelevel() { return experiencelevel; }
    

    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setDopes(int dopes) { this.dopes = dopes; }
    public void setSide(String side) { this.side = side; }
    public void setStatus(String status) { this.status = status; }
    public void setExperiencelevel(String experiencelevel) { this.experiencelevel = experiencelevel; }
}

 class Main {
    public static void main(String[] args) {
        Mafiaplayer player1 = new Mafiaplayer();
        System.out.println("First Item");
        System.out.println("Nickame: " + player1.getNickname());
        System.out.println("Doped: " + player1.getdopes());
        System.out.println("Side: " + player1.getSide());
        System.out.println("Status: " + player1.getStatus());
        System.out.println("Experiencelevel: " + player1.getExperiencelevel());

        Mafiaplayer player2 = new Mafiaplayer("Gabu", 8, "Mafia", "Won", "4");
        System.out.println("\nSecond Item:");
        System.out.println("Nickname: " + player2.getNickname());
        System.out.println("Dopes: " + player2.getdopes());
        System.out.println("Side: " + player2.getSide());
        System.out.println("Status: " + player2.getStatus());
        System.out.println("Experiencelevel: " + player2.getExperiencelevel());

        player1.setNickname("Lugaru");
        player1.setDopes(7);
        player1.setSide("Mafia");
        player1.setStatus("won");
        player1.setExperiencelevel("11");

        System.out.println("\nUpdated First Item:");
        System.out.println("Nickname: " + player1.getNickname());
        System.out.println("Dopes: " + player1.getdopes());
        System.out.println("Side: " + player1.getSide());
        System.out.println("Status: " + player1.getStatus());
        System.out.println("Experiencelevel: " + player1.getExperiencelevel());
    }
}