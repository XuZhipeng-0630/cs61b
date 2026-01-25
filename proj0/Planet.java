public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }
    public double calcForceExertedBy(Planet p){
        return G * mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
    }
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - xxPos;
        return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - yyPos;
        return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double totalForceX=0;
        for (Planet p : allPlanets){
            if (this.equals(p)){
                continue;
            }
            totalForceX += this.calcForceExertedByX(p);
        }
        return totalForceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double totalForceY=0;
        for (Planet p : allPlanets){
            if (this.equals(p)){
                continue;
            }
            totalForceY += this.calcForceExertedByY(p);
        }
        return totalForceY;
    }
    public void update(double dt, double fX, double fY){
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}