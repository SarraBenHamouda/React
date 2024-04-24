package tn.esprit.interfaces;

import java.util.List;

public interface ICommandesService<C> {
    void addCommande(C c);
    void removeCommande(int id);
    void updateCommande(C c);
    C getCommandeById(int id);
    List<C> getAllCommande();
}
