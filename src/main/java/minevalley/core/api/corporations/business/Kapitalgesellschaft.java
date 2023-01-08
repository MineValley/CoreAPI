package minevalley.core.api.corporations.business;

import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Group;

import java.util.List;

public interface Kapitalgesellschaft extends Group {

    List<Shareholder> getShareholders();

    void distribution(int distributionInCents);

    interface Shareholder {

        Registrant getRegistrant();

        int getShareInPercent();

        void transfer(Registrant registrant, int shareInPercent);
    }
}
