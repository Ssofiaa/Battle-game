import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Image;
import java.net.URL;

public class JuegoBatalla {

    public static void main(String[] args) {

        aplicarEstilo();

        String[] opciones = {"Mago (Lux)", "Tanque (Garen)", "Luchador (Sett)"};

        int eleccion = JOptionPane.showOptionDialog(
                null,
                "<html><h1 style='color:#00e5ff;'>Juego de Batalla</h1>"
                        + "<p style='font-size:16px; color:white;'>Elige tu personaje</p></html>",
                "Selección de Personaje",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (eleccion == -1) {
            JOptionPane.showMessageDialog(null, "Juego cancelado");
            System.exit(0);
        }

        Personaje jugador = null;
        ImageIcon imagenJugador = null;
        Personaje enemigo = new Personaje("Darius", 120, 18, 6);
        ImageIcon imagenEnemigo = null;

        try {
            switch (eleccion) {
                case 0:
                    jugador = new Mago("Lux");
                    imagenJugador = cargarImagenEscalada(
                            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Lux_8.jpg",
                            420,
                            240
                    );
                    break;

                case 1:
                    jugador = new Tanque("Garen");
                    imagenJugador = cargarImagenEscalada(
                            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Garen_5.jpg",
                            420,
                            240
                    );
                    break;

                case 2:
                    jugador = new Luchador("Sett");
                    imagenJugador = cargarImagenEscalada(
                            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Sett_45.jpg",
                            420,
                            240
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Selección inválida");
                    System.exit(0);
            }

            imagenEnemigo = cargarImagenEscalada(
                    "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Darius_0.jpg",
                    420,
                    240
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando imágenes: " + e.getMessage());
            System.exit(0);
        }

        JOptionPane.showMessageDialog(
                null,
                "<html><h1 style='color:#00ffcc;'>Personaje seleccionado</h1>"
                        + "<p style='font-size:18px; color:white;'>Elegiste a: <b>"
                        + jugador.getNombre()
                        + "</b></p></html>",
                "Jugador Seleccionado",
                JOptionPane.INFORMATION_MESSAGE,
                imagenJugador
        );

        while (jugador.estaVivo() && enemigo.estaVivo()) {

            String[] acciones = {"Atacar", "Ver estado", "Salir"};

            int accion = JOptionPane.showOptionDialog(
                    null,
                    "<html><h1 style='color:#ffd54f;'>Turno de " + jugador.getNombre() + "</h1>"
                            + "<p style='font-size:16px; color:white;'>¿Qué deseas hacer?</p></html>",
                    "Menú de Batalla",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    imagenJugador,
                    acciones,
                    acciones[0]
            );

            if (accion == -1 || accion == 2) {
                JOptionPane.showMessageDialog(null, "Saliste del juego");
                System.exit(0);
            }

            switch (accion) {
                case 0:
                    jugador.atacar(enemigo);

                    JOptionPane.showMessageDialog(
                            null,
                            "<html><h1 style='color:#00ffcc;'>⚔ ATAQUE ⚔</h1>"
                                    + "<p style='font-size:18px; color:white;'>"
                                    + jugador.getNombre() + " atacó a " + enemigo.getNombre()
                                    + "<br><br>Vida restante de " + enemigo.getNombre() + ": <b>"
                                    + enemigo.getVida() + "</b></p></html>",
                            "Ataque",
                            JOptionPane.INFORMATION_MESSAGE,
                            imagenJugador
                    );

                    if (enemigo.estaVivo()) {
                        enemigo.atacar(jugador);

                        JOptionPane.showMessageDialog(
                                null,
                                "<html><h1 style='color:#ff5252;'>⚠ CONTRAATAQUE ⚠</h1>"
                                        + "<p style='font-size:18px; color:white;'>"
                                        + enemigo.getNombre() + " contraatacó a " + jugador.getNombre()
                                        + "<br><br>Tu vida restante: <b>"
                                        + jugador.getVida() + "</b></p></html>",
                                "Contraataque",
                                JOptionPane.WARNING_MESSAGE,
                                imagenEnemigo
                        );
                    }
                    break;

                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "<html>"
                                    + "<h1 style='color:#64ffda;'>ESTADO DE BATALLA</h1>"
                                    + "<p style='font-size:18px; color:white;'>"
                                    + "<b>TU PERSONAJE</b><br>"
                                    + "Nombre: " + jugador.getNombre() + "<br>"
                                    + "Vida: " + jugador.getVida() + "<br>"
                                    + "Ataque: " + jugador.getAtaque() + "<br>"
                                    + "Defensa: " + jugador.getDefensa() + "<br><br>"
                                    + "<b>ENEMIGO</b><br>"
                                    + "Nombre: " + enemigo.getNombre() + "<br>"
                                    + "Vida: " + enemigo.getVida() + "<br>"
                                    + "Ataque: " + enemigo.getAtaque() + "<br>"
                                    + "Defensa: " + enemigo.getDefensa()
                                    + "</p></html>",
                            "Estado de batalla",
                            JOptionPane.INFORMATION_MESSAGE,
                            imagenJugador
                    );
                    break;
            }
        }

        if (jugador.estaVivo()) {
            JOptionPane.showMessageDialog(
                    null,
                    "<html><h1 style='color:#76ff03;'>🏆 ¡VICTORIA! 🏆</h1>"
                            + "<p style='font-size:20px; color:white;'>Ganaste la batalla con "
                            + jugador.getNombre() + "</p></html>",
                    "Victoria",
                    JOptionPane.INFORMATION_MESSAGE,
                    imagenJugador
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "<html><h1 style='color:#ff1744;'>💀 DERROTA 💀</h1>"
                            + "<p style='font-size:20px; color:white;'>Has sido derrotado por "
                            + enemigo.getNombre() + "</p></html>",
                    "Derrota",
                    JOptionPane.ERROR_MESSAGE,
                    imagenEnemigo
            );
        }
    }

    public static void aplicarEstilo() {
        UIManager.put("OptionPane.background", new java.awt.Color(18, 18, 18));
        UIManager.put("Panel.background", new java.awt.Color(18, 18, 18));
    }

    public static ImageIcon cargarImagenEscalada(String url, int ancho, int alto) throws Exception {
        ImageIcon iconoOriginal = new ImageIcon(new URL(url));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}