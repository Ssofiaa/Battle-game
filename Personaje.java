public class Personaje {

    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;

   
    public Personaje(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }


    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

   
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

   
    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
    }

    public void recibirDanio(int danio) {
        int danioFinal = danio - defensa;

        if (danioFinal < 0) {
            danioFinal = 0;
        }

        vida -= danioFinal;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nombre + " recibió " + danioFinal + " de daño");
    }

    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.getNombre());
        enemigo.recibirDanio(this.ataque);
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}