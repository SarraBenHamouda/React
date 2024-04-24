package tn.esprit.services;



import tn.esprit.interfaces.ICommandeService;
import tn.esprit.tools.MyConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Commande implements ICommandeService<tn.esprit.entites.Commande> {

    @Override
    public void addCommande(tn.esprit.entites.Commande commande) {
        String query = "INSERT INTO commande(num_commande, code_promo, type_paiement, email, date_commande, prix) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setString(1, commande.getNum_commande());
            pst.setString(2, commande.getCode_promo());
            pst.setString(3, commande.getType_paiement());
            pst.setString(4, commande.getEmail());
            pst.setDate(5, (Date) commande.getDate_commande());
            pst.setDouble(6, commande.getPrix());
            pst.executeUpdate();
            System.out.println("Commande ajoutée avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la destination: " + e.getMessage());
        }
    }

    @Override
    public void removeCommande(int id) {
        String query = "DELETE FROM commande WHERE id = ?";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Commande supprimée avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la destination: " + e.getMessage());
        }

    }

    @Override
    public void updateCommande(tn.esprit.entites.Commande commande) {
        String query = "UPDATE commande SET num_commande = ? , code_promo = ? , type_paiement = ?, email = ?, date_commande = ?, prix = ? WHERE id = ?";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setString(1, commande.getNum_commande());
            pst.setString(2, commande.getCode_promo());
            pst.setString(3, commande.getType_paiement());
            pst.setString(4, commande.getEmail());
            pst.setDate(5, commande.getDate_commande());
            pst.setDouble(6, commande.getPrix());
            pst.executeUpdate();
            System.out.println("Destination mise à jour avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de la destination: " + e.getMessage());
        }
    }

    @Override
    public tn.esprit.entites.Commande getCommandeById(int id) {
        String query = "SELECT * FROM commande WHERE id = ?";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    tn.esprit.entites.Commande commande = new tn.esprit.entites.Commande();
                    commande.setId(rs.getInt("id"));
                    commande.setNum_commande(rs.getString("num_commande"));
                    commande.setCode_promo(rs.getString("code_promo"));
                    commande.setEmail(rs.getString("email"));
                    commande.setPrix(rs.getDouble("prix"));
                    commande.setDate_commande(rs.getDate("date_commande"));
                    commande.setType_paiement(rs.getString("type_paiement"));

                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la destination: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<tn.esprit.entites.Commande> getAllCommandes() {
        List<tn.esprit.entites.Commande> CommandeList = new ArrayList<>();
        String query = "SELECT * FROM commande";
        try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    tn.esprit.entites.Commande commande = new tn.esprit.entites.Commande();
                    commande.setId(rs.getInt("id"));
                    commande.setNum_commande(rs.getString("num_commande"));
                    commande.setCode_promo(rs.getString("code_promo"));
                    commande.setEmail(rs.getString("email"));
                    commande.setPrix(rs.getDouble("prix"));
                    commande.setDate_commande(rs.getDate("date_commande"));
                    commande.setType_paiement(rs.getString("type_paiement"));

                    CommandeList.add(commande);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des destinations: " + e.getMessage());
        }
        return CommandeList;
    }
}
