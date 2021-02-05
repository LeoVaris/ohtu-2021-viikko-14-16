package statistics;

import statistics.matcher.*;

public class QueryBuilder {
    Matcher m;

    public QueryBuilder() {
        m = new All();
    }

    public Matcher build() {
        Matcher ret = m;
        m = new All();
        return ret;
    }

    public QueryBuilder playsIn(String t) {
        this.m = new And(m, new PlaysIn(t));
        return this;
    }

    public QueryBuilder hasAtLeast(int g, String t) {
        this.m = new And(m, new HasAtLeast(g, t));
        return this;
    }

    public QueryBuilder hasFewerThan(int g, String t) {
        this.m = new And(m, new HasFewerThan(g, t));
        return this;
    }

    public QueryBuilder oneOf(Matcher... mx) {
        this.m = new Or(mx);
        return this;
    }
}
