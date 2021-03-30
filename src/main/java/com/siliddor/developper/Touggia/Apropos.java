
package com.siliddor.developper.Touggia;

import com.siliddor.developper.Personnalisation.BarreVerticalPerso;
import com.siliddor.developper.Personnalisation.MenuOptions;
import com.siliddor.developper.Personnalisation.MesCouleurs;
import com.siliddor.developper.Personnalisation.MesPolices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



public class Apropos extends JPanel {

    private JPanel barreEntete, barreEnDessous, panneauPrincipal,
            containerApropos, containerCredits, containerRemerciements, containerCoordonnees, containerPolitique;
    private JScrollPane panneauGlisser, panneauGlisserPrincipal, panneauGllisserPolitique;
    private JButton boutonRetour;
    private JLabel aPropos, titreApropos, txtApropos, titreCredit, txtCredits, titreRemerciements, txtRemerciements,
                    siliddor, logoViteABord, titrePolitique, txtPolitique;
    private BufferedImage iconeBoutonRetour;
            
    
    
    
    public Apropos() {
        
        initComponents();
        DisposerElements();
        DefinirElements();
        AfficherMenuOptions();
    }
    

    
    
    private void DisposerElements(){
        
        //Instanciation des elements
        barreEntete = new JPanel();
        panneauPrincipal = new JPanel();
        barreEnDessous = new JPanel();
        boutonRetour = new JButton();
        aPropos = new JLabel();
        titreApropos = new JLabel();
        txtApropos = new JLabel();
        titreCredit = new JLabel();
        txtCredits = new JLabel();
        titreRemerciements = new JLabel();
        txtRemerciements = new JLabel();
        siliddor = new JLabel();
        logoViteABord = new JLabel();
        containerApropos = new JPanel();
        containerRemerciements = new JPanel();
        containerCredits = new JPanel();
        containerPolitique = new JPanel();
        containerCoordonnees = new JPanel();
        titrePolitique = new JLabel();
        txtPolitique = new JLabel();
        
        //Creation et definiton du paneau principal
        setBackground(MesCouleurs.BLANC);
        
        
        //Creation de licone du boutonRetour
        try {
            
            iconeBoutonRetour = ImageIO.
                    read(ClassLoader.getSystemResource("bouton_retour.png"));
            Image image = iconeBoutonRetour.getScaledInstance(50, 50,
                       Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
            boutonRetour.setIcon(icon);

        } catch (IOException ex) {
        }
        
        
        /**********************************
            Dispositon des elements de la barre d'entete
        *****************************/
        GridBagLayout grilleBarreEntete = new GridBagLayout();
        
        barreEntete.setLayout(grilleBarreEntete);
        GridBagConstraints gbcBarreEntete = new GridBagConstraints();
        
        gbcBarreEntete.weighty = 1;
        gbcBarreEntete.weightx = 0;
        
        gbcBarreEntete.gridx = 0;
        gbcBarreEntete.gridy = 0;
        gbcBarreEntete.fill = GridBagConstraints.NONE;
        gbcBarreEntete.ipadx = gbcBarreEntete.anchor = GridBagConstraints.LINE_START;
        barreEntete.add(boutonRetour, gbcBarreEntete);
        
        gbcBarreEntete.weightx = 1;
        gbcBarreEntete.ipadx = gbcBarreEntete.anchor = GridBagConstraints.CENTER;
        gbcBarreEntete.gridx = 1;
        gbcBarreEntete.gridy = 0;
        barreEntete.add(aPropos, gbcBarreEntete);
        /******************************************************************/
        
        
        /**********
            Disposition des elements des differents container
        */
        //Container Apropos
        panneauGlisser = new JScrollPane(containerApropos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panneauGlisser.setPreferredSize(new Dimension(600, 0));
        panneauGlisser.getViewport().setBackground(getBackground());
        panneauGlisser.setBorder(new EmptyBorder(0, 0, 0, 0));
        panneauGlisser.setVerticalScrollBar(new BarreVerticalPerso());
        BarreVerticalPerso barreVerticalPerso = new BarreVerticalPerso();
        barreVerticalPerso.setOrientation(JScrollBar.HORIZONTAL);
        panneauGlisser.setHorizontalScrollBar(barreVerticalPerso);
        
        GridBagLayout grilleApropos = new GridBagLayout();
        GridBagConstraints gbcApropos = new GridBagConstraints();
        
        containerApropos.setBackground(getBackground());
        containerApropos.setLayout(grilleApropos);
        containerPolitique.setBackground(getBackground());
        containerPolitique.setLayout(grilleApropos);
        
        gbcApropos.fill = GridBagConstraints.HORIZONTAL;
        gbcApropos.weightx = 0;
        gbcApropos.gridx = 0;
        gbcApropos.gridy = 0;
        gbcApropos.gridwidth = GridBagConstraints.REMAINDER;
        containerApropos.add(titreApropos, gbcApropos);
        containerPolitique.add(titrePolitique, gbcApropos);
        
        gbcApropos.weighty = 1;
        gbcApropos.fill = GridBagConstraints.NONE;
        gbcApropos.gridx = 0;
        gbcApropos.gridy = 1;
        gbcApropos.gridwidth = GridBagConstraints.REMAINDER;
        containerApropos.add(txtApropos, gbcApropos);
        containerPolitique.add(txtPolitique, gbcApropos);
        
        //Container credits
        GridBagLayout grilleCredits = new GridBagLayout();
        containerCredits.setLayout(grilleCredits);
        containerCredits.setBackground(MesCouleurs.BLANC);
        GridBagConstraints gbcCredits = new GridBagConstraints();
        
        gbcCredits.gridx = 0;
        gbcCredits.gridy = 0;
        containerCredits.add(titreCredit, gbcCredits);
        
        gbcCredits.ipadx = 0;
        gbcCredits.gridy = 1;
        containerCredits.add(txtCredits, gbcCredits);
        
        //Container remerciements
        //GridBagLayout grilleRemerciements = new GridBagLayout();
        //containerRemerciements.setLayout(grilleRemerciements);
        //GridBagConstraints gbcRemerciements = new GridBagConstraints();
        
        gbcCredits.gridx = 0;
        gbcCredits.gridy = 2;
        containerCredits.add(titreRemerciements, gbcCredits);
        
        gbcCredits.gridx = 0;
        gbcCredits.gridy = 3;
        containerCredits.add(txtRemerciements, gbcCredits);
        
        
        //Container coordonnees
        GridBagLayout grilleCoordonnees = new GridBagLayout();
        GridBagConstraints gbcCoordonnees = new GridBagConstraints();
        containerCoordonnees.setLayout(grilleCoordonnees);
        containerCoordonnees.setBackground(MesCouleurs.BLANC);
        
        gbcCoordonnees.gridx = 0;
        gbcCoordonnees.gridy = 0;
        gbcCoordonnees.insets = new Insets(0, 0, 0, 15);
        containerCoordonnees.add(siliddor, gbcCoordonnees);
        
        
        
        panneauGllisserPolitique = new JScrollPane(containerPolitique, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panneauGllisserPolitique.setPreferredSize(new Dimension(600, 0));
        panneauGllisserPolitique.getViewport().setBackground(getBackground());
        panneauGllisserPolitique.setBorder(new EmptyBorder(0, 0, 0, 0));
        panneauGllisserPolitique.setVerticalScrollBar(new BarreVerticalPerso());
        barreVerticalPerso.setOrientation(JScrollBar.HORIZONTAL);
        panneauGllisserPolitique.setHorizontalScrollBar(barreVerticalPerso);
        /*******************************************/
        
        
        //Configuration du panneau glisser
        panneauGlisserPrincipal = new JScrollPane(panneauPrincipal, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panneauGlisserPrincipal.getViewport().setBackground(getBackground());
        panneauGlisserPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));
        panneauGlisserPrincipal.setVerticalScrollBar(new BarreVerticalPerso());
        panneauGlisserPrincipal.setHorizontalScrollBar(barreVerticalPerso);
        
        
        /********************
            Disposition des elements sur la grille
        *************************/
        GridBagLayout gridBagLayout = new GridBagLayout();
        panneauPrincipal.setLayout(gridBagLayout);
        panneauPrincipal.setBackground(getBackground());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panneauPrincipal.add(barreEntete, gbc);
        
        gbc.insets = new Insets(30, 30, 0, 0);
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panneauPrincipal.add(panneauGlisser, gbc);
        
        gbc.ipadx = gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panneauPrincipal.add(containerCredits, gbc);
        
        gbc.ipadx = gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 30, 0, 0);
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panneauPrincipal.add(containerCoordonnees, gbc);
        
        gbc.ipadx = gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panneauPrincipal.add(containerRemerciements, gbc);
        
        gbc.ipadx = gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panneauPrincipal.add(containerPolitique, gbc);
        
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panneauPrincipal.add(barreEnDessous, gbc);
        
        barreEnDessous.setLayout(gridBagLayout);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        barreEnDessous.add(logoViteABord);
        
        GridBagLayout grillePprincipal = new GridBagLayout();
        this.setLayout(grillePprincipal);
        
        GridBagConstraints gbcPprincipal = new GridBagConstraints();
        
        gbcPprincipal.weightx = 1;
        gbcPprincipal.weighty = 1;
        gbcPprincipal.gridx = 0;
        gbcPprincipal.gridy = 0;
        gbcPprincipal.fill = GridBagConstraints.BOTH;
        gbcPprincipal.gridwidth = GridBagConstraints.REMAINDER;
        this.add(panneauGlisserPrincipal, gbcPprincipal);
        
    }
    
    
    
    
    private void DefinirElements(){
        
       boutonRetour.setBackground(MesCouleurs.BLEU);
       boutonRetour.setBorderPainted(false);
       boutonRetour.setFocusPainted(false);
       
       barreEntete.setBackground(MesCouleurs.BLEU);
       barreEntete.setPreferredSize(new Dimension(0, 60));
        
       aPropos.setText("À propos");
       aPropos.setFont(MesPolices.Black(40));
       aPropos.setForeground(MesCouleurs.BLANC);
       
       titreApropos.setText("À propos de Touggia");
       titreApropos.setForeground(Color.BLACK);
       titreApropos.setFont(MesPolices.Bold(30));
       titreApropos.setPreferredSize(new Dimension(250, 50));
       titreApropos.setHorizontalAlignment(JLabel.CENTER);
       
       
       String texte = "Touggia (<i>prononcé toujia</i>) est une plateforme conçue\n" +
        "et promue par le Laboratoire d'Informatique, de Design,\n" +
        "de Développement Web & Mobile et de Sécurité\n" +
        "Informatique(SILIDDOR) en 2021 dont OUOROU\n" +
        "Rachid est le Fondateur/PDG. L'application \n" +
        "permet aux étudiants de payer leurs tickets de bus \n" +
        "et de restaurant sans se déplacer à n'importe où\n" +
        "et n'importe quand. Fini la queue dans le campus\n" +
        "pour se payer un ticket et fini les peurs de rater le \n" +
        "bus car nous vous informons en temps réel des";
       String texte1 = String.format("<html><body style=\"text-align: left; \">%s</body></html>", texte);
       
       txtApropos.setText(texte1);
       txtApropos.setForeground(Color.BLACK);
       txtApropos.setFont(MesPolices.Medium(20));
       txtApropos.setHorizontalAlignment(JLabel.CENTER);
       txtApropos.setPreferredSize(new Dimension(600, 300));
       
       titreCredit.setText("Crédits:");
       titreCredit.setFont(MesPolices.Bold(30));
       titreCredit.setForeground(Color.BLACK);
       
       txtCredits.setText("-SILIDDOR Soft (pour la conception et le développement).");
       txtCredits.setForeground(Color.BLACK);
       txtCredits.setFont(MesPolices.Medium(20));
       
       titreRemerciements.setText("Remerciements:");
       titreRemerciements.setFont(MesPolices.Bold(30));
       titreRemerciements.setForeground(Color.BLACK);
       
       txtRemerciements.setText("Les remerciements");
       txtRemerciements.setForeground(Color.BLACK);
       txtRemerciements.setFont(MesPolices.Medium(20));
       
       siliddor.setText("SILIDDOR Inc. | SILIDDOR Softwares ©2021 Copyright");
       siliddor.setForeground(MesCouleurs.BLEU);
       siliddor.setFont(MesPolices.Bold(25));
       
       titrePolitique.setText("Notre politique de  confidentialité");
       titrePolitique.setForeground(Color.BLACK);
       titrePolitique.setFont(MesPolices.Bold(30));
       titrePolitique.setPreferredSize(new Dimension(250, 50));
       titrePolitique.setHorizontalAlignment(JLabel.CENTER);
       
       txtPolitique.setText(LireTexte("politique_confidentialite.html"));
       txtPolitique.setForeground(Color.BLACK);
       txtPolitique.setFont(MesPolices.Medium(20));
       txtPolitique.setHorizontalAlignment(JLabel.CENTER);
       txtPolitique.setPreferredSize(new Dimension(600, 300));
       
       
       barreEnDessous.setBackground(MesCouleurs.BLEU);
       barreEnDessous.setPreferredSize(new Dimension(0, 40));
       
       logoViteABord.setText("Vite à bord !");
       logoViteABord.setFont(MesPolices.Bickley(45));
       logoViteABord.setForeground(MesCouleurs.BLANC);
    }
    
   
    private String LireTexte(String fichier){
        StringBuilder builder = new StringBuilder();
        try {
            //FileInputStream inputStream = new FileInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(ClassLoader.getSystemResource(fichier).openStream(), StandardCharsets.UTF_8);
            try (BufferedReader br = new BufferedReader(inputStreamReader)) {
                String s;
                while ((s = br.readLine()) != null) {
                    builder.append(s);
                }
            }
        } catch (IOException ex) {
            
        }
        String stringFormated = String.format("<html><body style=\"text-align: left; text-justify: auto;\">%s</body></html>", builder.toString());
        return stringFormated;
    }
    
    
     private void AfficherMenuOptions(){
        
        MenuOptions menuOptions = new MenuOptions(panneauGlisserPrincipal);
        MenuOptions menuOptions1 = new MenuOptions(panneauGlisser);
        
        ActionListener quitter = (ActionEvent e) -> {
            menuOptions.ConfirmationFermeture((JFrame) SwingUtilities.getWindowAncestor(Apropos.this));
        };
        menuOptions.AjouterMenu("Quitter", quitter);
        menuOptions1.AjouterMenu("Quitter", quitter);
    }
    
    public JButton BoutonRetour(){
        return boutonRetour;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
