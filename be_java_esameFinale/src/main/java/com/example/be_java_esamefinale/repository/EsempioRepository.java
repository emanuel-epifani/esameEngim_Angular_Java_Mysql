package com.example.be_java_esamefinale.repository;

public class EsempioRepository {

    //select SENZA prepare statement (senza variabile al suo interno)

//        public static List<Fermata> getFermate(){
//            // creo una lista da restituire
//            List<Fermata> fermate = new ArrayList<>();
//            try{
//                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                PreparedStatement stmt = conn.prepareStatement("select id, nome, zona from fermate");
//                ResultSet rs = stmt.executeQuery();
//
//                while(rs.next()){
//
//                    // creo una fermata con i dati del DB
//                    Fermata fermata = new Fermata(
//                            rs.getInt("id"),
//                            rs.getString("nome"),
//                            rs.getString("zona"));
//
//                    // aggiungo alla lista
//                    fermate.add(fermata);
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //restituisco la lista
//            return fermate;
//        }




    //select CON prepare statement (con variabile al suo interno)

//        private static Fermata getFermataById(int numero_fermata) {
//            // dichiaro l'oggetto da restituire
//            Fermata fermata = null;
//            try{
//                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                PreparedStatement stmt = conn.prepareStatement("select id,nome,zona from fermate where id = ? ");
//                stmt.setInt(1,numero_fermata);
//                ResultSet rs = stmt.executeQuery();
//
//                while(rs.next()){
//                    // istanzio l'oggetto da restituire preso dal DB
//                    fermata = new Fermata(rs.getInt("id"),rs.getString("nome"),rs.getString("zona"));
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //restituisco la Fermata
//            return fermata;
//        }


}
