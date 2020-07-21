package com.UsuariosManager;
import com.BST.BinaryTree;
import com.EmpresasManager.Empresa;
import com.JsonManager.CambiarValorJson;
import com.JsonManager.CreateJsonEmpresa;
import com.JsonManager.CreateJsonReceta;
import com.JsonManager.CreateJsonUser;
import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;
import com.SPLAY.SplayTree;
import com.SortAlgorithms.InsertionSort;
import com.StackPackage.Stack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/***
 * This class manages all the background process to store information in the server
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class ManejoUsuarios {

    BinaryTree usuarios;
    CreateJsonUser jsonUser = new CreateJsonUser();
    SplayTree empresas = new SplayTree();

    /***
     * Constructor method of the 'ManejoUsuarios' class.
     */
    public ManejoUsuarios() {
        usuarios = new BinaryTree();

    }

    /***
     *This method does a sign-in verification of e-mail and password.
     * @param usuario Usuario
     * @return String
     */
    public String verificacion(Usuario usuario) {
        if (usuarios.contains(usuario)==true){
            Usuario temp = usuarios.getbyEmail(usuario.getEmail());
            usuario.setPassword(MD5.encriptar(usuario.getPassword()));
            if (temp.getPassword().equals(usuario.getPassword())){
                return "InicioCorrecto";

            }else{
                return "ContraseñaIncorrecta";

            }
        }else{
            return "UsuarioNoRegistrado";
        }
    }

    /***
     *This method creates a new user and adds it to the user's Json file.
     * @param nuevo Usuario
     * @return String
     * @throws NoSuchAlgorithmException
     */
    public String crearUsuario(Usuario nuevo) throws NoSuchAlgorithmException{
        if (usuarios.contains(nuevo)==true){

            return RegistroUsuario.usuarioExst(true);

        }else {
            Usuario usuario = new Usuario();
            usuario.setNombre(nuevo.getNombre());
            usuario.setEmail(nuevo.getEmail());
            usuario.setEdad(nuevo.getEdad());
            usuario.setPassword(MD5.encriptar(nuevo.getPassword()));


            try {

                jsonUser.usuarioJson(usuario);
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.usuarios.insert(usuario);
            return RegistroUsuario.usuarioExst(false);
        }


    }

    /***
     *This method extracts an user from the user's BST.
     * @param nombre String
     * @return Usuario
     */
    public Usuario getUser(String nombre){
        return usuarios.getbyName(nombre);

    }

    /***
     *This method returns the user's BST.
     * @return BinaryTree
     */
    public BinaryTree getUsuarios() {
        return usuarios;
    }

    /***
     *This method adds a new recipe to the user's AVL tree, the own MyMenu and the NewsFeed of all
     * of the user's followers.
     * @param receta Receta
     * @return String
     * @throws IOException
     */
    public String agregarReceta(Receta receta) throws IOException {
        if (usuarios.getbyName(receta.getAutor()).getRecetas().contains(receta.getName())==true){
            return "ERROR";

        }else{
            Calendar c = Calendar.getInstance();
            receta.setDia(c.get(Calendar.DATE));
            receta.setMes(c.get(Calendar.MONTH));
            addinmyMenu(receta);
            usuarios.getbyName(receta.getAutor()).getRecetas().insert(receta);
            usuarios.getbyName(receta.getAutor()).getNewsFeed().getStack().push(receta);
            CreateJsonReceta r = new CreateJsonReceta();
            r.recetaJson(receta);
            for(int i = 0; i < usuarios.getbyName(receta.getAutor()).getSeguidores().getSize(); i++){

                usuarios.getbyName(usuarios.getbyName(receta.getAutor()).getSeguidores().get(i)).getNewsFeed().getStack().push(receta);
            }
            return "Agregada";
        }

    }

    /***
     *This method adds a recipe in the user's MyMenu.
     * @param receta Receta
     */
    public void addinmyMenu(Receta receta){
        Receta[] receta1 = new Receta[usuarios.getbyName(receta.getAutor()).getMyMenu().getLista().getSize()+1];
        for (int i = 0;i<usuarios.getbyName(receta.getAutor()).getMyMenu().getLista().getSize();i++){
            MyMenu myMenu = usuarios.getbyName(receta.getAutor()).getMyMenu();
            receta1[i] = usuarios.getbyName(myMenu.getLista().get(i)[0]).getRecetas().search(myMenu.getLista().get(i)[1]);

        }
        receta1[usuarios.getbyName(receta.getAutor()).getMyMenu().getLista().getSize()]  = receta;
        switch (usuarios.getbyName(receta.getAutor()).getOState()){
            case 0:
                usuarios.getbyName(receta.getAutor()).getMyMenu().setLista(InsertionSort.covertToDate(receta1));

        }
    }

    /***
     * This method adds a new company to the appropriate Splay tree and to the Json file.
     * @param empresa Empresa
     * @param name String
     * @return String
     */
    public String agregarEmpresa(Empresa empresa, String name) {

        if (empresas.contains(empresa.getNombre())==true){
            return "ERROR";

        }else {
            empresas.insert(empresa);
            usuarios.getbyName(name).getEmpresa().add(empresa.getNombre());
            CreateJsonEmpresa e = new CreateJsonEmpresa();
            CambiarValorJson.agregarEmpresa(name,empresa.getNombre());
            try {
                e.empresaJson(empresa);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return "ACEPTADA";
        }


    }

    /***
     * This method loads in the BST all of the users from the Json file.
     */
    public void cargarUsuarios(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
            for (Object o : a)
            {
                Usuario usuario = new Usuario();
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                usuario.setNombre(name);
                System.out.println("nombre : " + name);
                String password = (String) obj.get("password");
                usuario.setPassword(password);
                System.out.println("password : " + password);
                long edad = (long) obj.get("edad");
                usuario.setEdad((int)edad);
                System.out.println("edad: " + edad);
                Boolean chef = (Boolean) obj.get("chef");
                usuario.setIsChef(chef);
                System.out.println("chef : " + chef);
                String email = (String) obj.get("email");
                usuario.setEmail(email);
                System.out.println("email :"+email);
                JSONArray seguidos = (JSONArray) obj.get("seguidos");
                for(Object i : seguidos){
                    //JSONObject jsonObject = (JSONObject) i;
                    usuario.getSeguidos().add(i.toString());

                }
                JSONArray seguidores = (JSONArray) obj.get("seguidores");
                for(Object i : seguidores){
                    //JSONObject jsonObject = (JSONObject) i;
                    usuario.getSeguidores().add(i.toString());

                }
                System.out.println("/n");
                usuarios.insert(usuario);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /***
     *This method returns a JSON Array with all the showed elements in the NewsFeed.
     * @param nombre String
     * @return JSONArray
     */
    public JSONArray getNewsFeed(String nombre) {
        JSONArray jsonArray = new JSONArray();
        ListaEnlazada<Receta> recetas = new ListaEnlazada<Receta>();
        Stack stack = new Stack();
        while(usuarios.getbyName(nombre).getNewsFeed().getStack().isEmpty()==false){
            JSONObject jsonObject = new JSONObject();
            JSONArray ingredientes = new JSONArray();
            JSONArray dieta = new JSONArray();
            JSONArray pasos = new JSONArray();
            Receta receta = usuarios.getbyName(nombre).getNewsFeed().getStack().peek();
            jsonObject.put("name",receta.getName());
            jsonObject.put("autor",receta.getAutor());
            jsonObject.put("tipoPlato",receta.getTipoPlato());
            jsonObject.put("porciones",receta.getPorciones());
            jsonObject.put("duracion", receta.getDuracion());
            jsonObject.put("tiempo", receta.getTiempo());
            jsonObject.put("dificultad", receta.getDificultad());
            jsonObject.put("dieta",dieta);
            jsonObject.put("ingredientes",ingredientes);
            jsonObject.put("pasos",pasos);
            jsonObject.put("calificacion",receta.getCalificacion());
            jsonObject.put("mes",receta.getMes());
            jsonObject.put("dia",receta.getDia());
            for(int i=0; i < receta.getIngredientes().length;i++){
                ingredientes.add(receta.getIngredientes()[i]);


            }
            for(int i=0; i < receta.getDieta().length;i++){
                dieta.add(receta.getDieta()[i]);


            }
            for(int i=0; i < receta.getPasos().length;i++){
                pasos.add(receta.getPasos()[i]);


            }
            jsonArray.add(jsonObject);
            recetas.add((Receta)usuarios.getbyName(nombre).getNewsFeed().getStack().peek());
            usuarios.getbyName(nombre).getNewsFeed().getStack().pop();


        }
        for (int i = recetas.getSize()-1;i==0;i--){
            stack.push(recetas.get(i));

        }
        usuarios.getbyName(nombre).getNewsFeed().setStack(stack);
        return jsonArray;
    }

    /***
     *This method loads in each user AVL all the recipes stored in Json file.
     */
    public void cargarRecetas(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\Recetas.json"));
            for (Object o : a)
            {
                Receta receta = new Receta();
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("name");
                receta.setName(name);
                System.out.println("nombre : " + name);
                String autor = (String) obj.get("autor");
                receta.setAutor(autor);
                System.out.println("password : " + autor);
                long porciones = (long) obj.get("porciones");
                receta.setPorciones((int)porciones);
                System.out.println("porciones: " + porciones);
                long calificacion = (long) obj.get("calificacion");
                receta.setCalificacion((int)calificacion);
                System.out.println("calificacion: " + calificacion);
                String tiempo = (String) obj.get("tiempo");
                receta.setTiempo(tiempo);
                System.out.println("tiempo : " + tiempo);
                String tipo = (String) obj.get("tipoPlato");
                receta.setTipoPlato(tipo);
                System.out.println("tipo : " + tipo);
                String duracion = (String) obj.get("duracion");
                receta.setDuracion(duracion);
                System.out.println("duracion : " + duracion);
                long mes = (long) obj.get("mes");
                receta.setMes((int)mes);
                System.out.println("mes: " + mes);
                long dia = (long) obj.get("dia");
                receta.setDia((int)dia);
                System.out.println("dia: " + dia);
                long dificultad = (long) obj.get("dificultad");
                receta.setDificultad((int)dificultad);
                System.out.println("dificultad: " + dificultad);

                JSONArray ingredients = (JSONArray) obj.get("ingredientes");
                String[] ingredientes = new String[ingredients.size()];
                int cont = 0;
                for(Object i : ingredients){
                    ingredientes[cont]=i.toString();
                    cont++;

                }receta.setIngredientes(ingredientes);



                JSONArray pass = (JSONArray) obj.get("pasos");
                String[] pasos = new String[pass.size()];
                int cont2 = 0;
                for(Object i : pass){
                    pasos[cont2]=i.toString();
                    cont2++;

                }receta.setPasos(pasos);



                JSONArray diet = (JSONArray) obj.get("dieta");
                String[] dieta = new String[diet.size()];
                int cont3 = 0;
                for(Object i : diet){
                    dieta[cont3]=i.toString();
                    cont3++;

                }receta.setDieta(dieta);


                usuarios.getbyName(receta.getAutor()).getRecetas().insert(receta);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /***
     * This method loads in the Splay tree all of the companies stored in the Json file.
     */
    public void cargarEmpresas(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONEmpresas.json"));
            for (Object o : a)
            {
                Empresa empresa = new Empresa();
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                empresa.setNombre(name);
                System.out.println("nombre : " + name);
                String contacto = (String) obj.get("contacto");
                empresa.setContacto(contacto);
                System.out.println("contacto : " + contacto);
                String horario = (String) obj.get("horario");
                empresa.setHorario(horario);
                System.out.println("horario :"+horario);

                JSONArray seguidores = (JSONArray) obj.get("seguidores");
                for(Object i : seguidores){
                    //JSONObject jsonObject = (JSONObject) i;
                    empresa.getSeguidores().add(i.toString());

                }
                System.out.println("/n");
                empresas.insert(empresa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /***
     * This method returns the Splay tree of stored companies.
     * @return SplayTree
     */
    public SplayTree getEmpresas() {
        return empresas;
    }

    /***
     *This method returns a JSON array with all of the showed elements in the personal MyMenu of a certain user.
     * @param name String
     * @return JSONArray
     */
    public JSONArray getMyMenu(String name) {
        JSONArray genA = new JSONArray();
        ListaEnlazada<String[]> temp = usuarios.getbyName(name).getMyMenu().getLista();
        for(int i = 0; i < temp.getSize();i++){
            JSONObject jsonObject = new JSONObject();
            Receta receta = usuarios.getbyName(temp.get(i)[0]).getRecetas().search(temp.get(i)[1]);
            JSONArray ingredientes = new JSONArray();
            JSONArray dieta = new JSONArray();
            JSONArray pasos = new JSONArray();
                for(int j=0; i < receta.getIngredientes().length;i++){
                    ingredientes.add(receta.getIngredientes()[i]);


                }
                for(int j=0; i < receta.getDieta().length;i++){
                    dieta.add(receta.getDieta()[i]);


                }
                for(int j=0; i < receta.getPasos().length;i++){
                    pasos.add(receta.getPasos()[i]);


                }

                jsonObject.put("name",receta.getName());
                jsonObject.put("autor",receta.getAutor());
                jsonObject.put("tipoPlato",receta.getTipoPlato());
                jsonObject.put("porciones",receta.getPorciones());
                jsonObject.put("duracion", receta.getDuracion());
                jsonObject.put("tiempo", receta.getTiempo());
                jsonObject.put("dificultad", receta.getDificultad());
                jsonObject.put("dieta",dieta);
                jsonObject.put("ingredientes",ingredientes);
                jsonObject.put("pasos",pasos);
                jsonObject.put("calificacion",receta.getCalificacion());
                jsonObject.put("mes",receta.getMes());
                jsonObject.put("dia",receta.getDia());
                genA.add(jsonObject);
        }
        return genA;
    }
}
