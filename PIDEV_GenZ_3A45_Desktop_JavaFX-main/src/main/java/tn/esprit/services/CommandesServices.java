package tn.esprit.services;



import tn.esprit.interfaces.ICommandesService;
import tn.esprit.tools.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class CommandesServices implements ICommandesService<Commandes> {

    @Override
    public void addCommande(Commandes commandes) {
        String query = "INSERT INTO commande(num_commande, prix, code_promo, type_paiement, email, date_commande) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setString(1, commandes.getNum_commande());
            pst.setDouble(2, commandes.getPrix());
            pst.setString(3, commandes.getCode_promo());
            pst.setString(4, commandes.getType_paiement());
            pst.setString(5, commandes.getEmail());
            pst.setDate(6, commandes.getDate_commande());
            pst.executeUpdate();
            System.out.println("Commande ajoutée avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la commande: " + e.getMessage());
        }
    }

    @Override
    public void removeCommande(int id) {
        String query = "DELETE FROM commande WHERE id = ?";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Commandes supprimée avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la commande: " + e.getMessage());
        }
    }

    @Override
    public void updateCommande(Commandes commandes) {
        String query = "UPDATE commande SET num_commande = ?, prix = ?, code_promo = ?, type_paiement = ?, email = ?, date_commande = ? WHERE id = ?";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setString(1, commande.getNum_commande());
            pst.setDouble(2, commande.getPrix());
            pst.setString(3, commande.getCode_promo());
            pst.setString(4, commande.getType_paiement());
            pst.setString(5, commande.getEmail());
            pst.setDate(6, commande.getDate_commande());
            pst.setInt(7, commande.getId());
            pst.executeUpdate();
            System.out.println("Commande mise à jour avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de la commande: " + e.getMessage());
        }
    }

    @Override
    public Commandes getCommandeById(int id) {
        String query = "SELECT * FROM commande WHERE id = ?";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Commandes commandes = new Commandes();
                    Commandes.setId(rs.getInt("id"));
                    commandes.setNum_commande(rs.getString("num_commande"));
                    commandes.setPrix(rs.getDouble("prix"));
                    commandes.setCode_promo(rs.getString("code_promo"));
                    commandes.setType_paiement(rs.getString("type_paiement"));
                    commandes.setEmail(rs.getString("email"));
                    commandes.setDate_commande(rs.getDate("date_commande"));
                    return commandes;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la commande: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Commandes> getAllCommande() {
        List<Commandes> commandesList = new ArrayList<>();
        String query = "SELECT * FROM commande";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Commandes commandes = new Commandes();
                    commandes.setId(rs.getInt("id"));
                    commandes.setNum_commande(rs.getString("num_commande"));
                    commandes.setPrix(rs.getdouble("prix"));
                    commandes.setCode_promo(rs.getString("code_promo"));
                    commandes.setType_paiement(rs.getString("type_paiement"));
                    commandes.setEmail(rs.getString("mail"));
                    commandes.setDate_commande(rs.getDate("date_commande"));
                    commandesList.add(commandes);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des commandes: " + e.getMessage());
        }
        return commandesList;
    }
}
