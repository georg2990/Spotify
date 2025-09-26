public class Sang {
private String titel;
private Genre genre;

//konstruktør
public Sang(String titel, Genre genre){
    this.titel = titel;
    this.genre = genre;
}
//Getter
public String getTitel(){
    return titel;
}

public Genre getGenre(){
    return genre;
}
//setter
public void setTitel(String titel){
    this.titel = titel;
}
public void setGenre(Genre genre){
    this.genre = genre;
}


// to-String metode
@Override
public String toString(){
    return "Titel: " + titel + "| Genre: " + genre;
}
}


