
void main()
{
    int choix;
    Scanner scanner = new Scanner(System.in);
    do
    {
        do
        {
            System.out.println("1 - Tableau original");
            System.out.println("2 - Présence d'un employé");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
        } while (choix > 3);

        switch (choix)
        {
            case 0:
                System.out.println("Fin du devoir");
                break;
            case 1:
                // A vous de jouer
                int[] tab = new int[6];
                int some = 0;
                double caree_some = 0;

                for (int i = 0; i < 10; i ++) {
                    for (int j = 0; j < 6; j ++) {
                        tab[j] = (int)(Math.random() * 9);
                        some += tab[j];
                        System.out.print(tab[j] + " ");
                    }System.out.println();
                    System.out.println("somme = " + some);

                    caree_some = Math.sqrt((double) some);
                    if (Math.round(caree_some) == caree_some) {
                        System.out.println("Le tableau est original");
                    } else {
                        System.out.println("Le tableau n'est pas original");
                    }
                    some = 0;
                }

                break;
            case 2:
                // Ne pas effacer les tableaux
                String[][] employes =
                        {
                                {"1", "Enzo"},
                                {"2", "Noa"},
                                {"3", "Lilou"},
                                {"4", "Milo"},
                                {"5", "Kitty"}
                        };
                String[][] presences =
                        {
                                {"P", "P", "A","",""},
                                {"A", "P", "P", "P", "A"},
                                {"A", "A", "A", "P",""},
                                {"P", "P", "P", "P", "P"},
                                {"A", "P","","",""}
                        };

                // A vous de jouer
                int ne = -1;
                boolean presences_complete = true;
                int pos_remplacement = 0;
                String presence = "";

                System.out.println("Quel est le nom de l'employé : ");
                scanner.nextLine();
                String nom = scanner.nextLine();
                for (int i = 0; i < employes.length; i++) {
                    if (Objects.equals(employes[i][1], nom)) {
                        ne = i;
                        break;
                    }
                }
                if (ne == -1) {
                    System.out.println("Aucun étudiant trouvé avec ce nom");
                    break;
                }

                for (int i = 0; i < presences[ne].length; i ++) {
                    if (Objects.equals(presences[ne][i], "")) {
                        pos_remplacement = i;
                        presences_complete = false;
                        break;
                    }
                }
                if (presences_complete) {
                    System.out.println("Impossible d'ajouter une  présence");
                    break;
                } else {
                    do {
                        System.out.println("Présence de l'étudiant : ");
                        presence = scanner.next();
                    } while (!Objects.equals(presence, "A") && !Objects.equals(presence, "P"));
                }

                presences[ne][pos_remplacement] = presence;
                for (int i = 0; i < employes.length; i ++) {
                    System.out.print(employes[i][0] + " " + employes[i][1] + " ");
                    for (int j = 0; j < presences.length; j++) {
                        if (Objects.equals(presences[i][j], "")) {break;}
                        System.out.print(presences[i][j] + " ");
                    }
                    System.out.println();
                }

                break;
        }
    }while (choix != 0);
}
