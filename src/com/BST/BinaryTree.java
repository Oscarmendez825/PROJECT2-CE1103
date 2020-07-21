package com.BST;


import com.UsuariosManager.Usuario;

/***
 * Binary search tree class; stores the info of each user.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class BinaryTree {
	private Node root;

	/***
	 * This method verifies if the tree is empty
	 * @return Boolean
	 */
	public boolean isEmpty(){
		if (root == null){
			return true;
		}else {
			return false;
		}
	}

	/***
	 * Facade method of the true 'insert' method.
	 * @param data Usuario
	 */
	public void insert(Usuario data)
	{

		root = insert(root, data);
	}

	/***
	 * This method inserts a new user in the tree.
	 * @param root Node
	 * @param data Usuario
	 * @return Node
	 */
	private Node insert(Node root, Usuario data)
	{

		if (root == null)
		{
			return new Node(data);
		}
		else if (data.getNombre().compareTo(root.getData().getNombre()) < 0){
			root.setLeft(insert(root.getLeft(), data));
		}
		else if (data.getNombre().compareTo(root.getData().getNombre()) > 0)
		{
			root.setRight(insert(root.getRight(), data));
		}
		else
		{
			// We are disallowing insertion of duplicate values for
			// this assignment.
		}

		return root;
	}

	/***
	 * Facade method of the true 'delete' method.
	 * @param data Usuario
	 */
	public void delete(Usuario data)
	{

		root = delete(root, data);
	}

	/***
	 * This method finds and deletes a certain item of the tree
	 * @param root Node
	 * @param data Usuario
	 * @return Node
	 */
	private Node delete(Node root, Usuario data)
	{
		if (root == null)
		{
			return null;
		}
		else if (data.getNombre().compareTo(root.getData().getNombre()) < 0)
		{
			root.setLeft(delete(root.getLeft(), data));
		}
		else if (data.getNombre().compareTo(root.getData().getNombre()) > 0)
		{
			root.setRight(delete(root.getRight(), data));
		}
		else
		{
			if (root.getLeft() == null && root.getRight() == null)
			{
				return null;
			}
			else if (root.getRight() == null)
			{
				return root.getLeft();
			}
			else if (root.getLeft() == null)
			{
				return root.getRight();
			}
			else
			{
				root.setData(findMax(root.getLeft()));
				root.setLeft(delete(root.getLeft(), root.getData()));
			}
		}

		return root;
	}

	/***
	 * This method finds the furthest-to-the-right node on the given tree, or subtree in a certain cqse.
	 * @param root Node
	 * @return Usuario
	 */
	private Usuario findMax(Node root)
	{
		while (root.getRight() != null)
		{
			root = root.getRight();
		}

		return root.getData();
	}

	/***
	 * Facade method of the true 'contains' method.
	 * @param data Usuario
	 * @return Boolean
	 */
	public boolean contains(Usuario data)
	{

		return contains(root, data);
	}

	/***
	 * This method verifies if a certain user is in the tree.
	 * @param root Node
	 * @param data Usuario
	 * @return Boolean
	 */
	private boolean contains(Node root, Usuario data)
	{
		if (root == null)
		{
			return false;
		}
		else if (data.getEmail().compareTo(root.getData().getEmail()) < 0)
		{
			return contains(root.getLeft(), data);
		}
		else if (data.getEmail().compareTo(root.getData().getEmail()) > 0)
		{
			return contains(root.getRight(), data);
		}
		else
		{
			return true;
		}
	}

	/***
	 * Facade method of the true 'contains' method.
	 * @param data String
	 * @return Boolean
	 */
    public boolean contains(String data)
    {

        return contains(root, data);
    }
    private boolean contains(Node root, String data)
    {
        if (root == null)
        {
            return false;
        }
        else if (data.compareTo(root.getData().getNombre()) < 0)
        {
            return contains(root.getLeft(), data);
        }
        else if (data.compareTo(root.getData().getNombre()) > 0)
        {
            return contains(root.getRight(), data);
        }
        else
        {
            return true;
        }
    }

	/***
	 * Facade method of the true 'getbyEmail' method.
	 * @param email String
	 * @return Usuario
	 */
	public Usuario getbyEmail(String email){
		return getbyEmail(root,email);

	}

	/***
	 * This method finds an user by its 'email' atribute.
	 * @param root Node
	 * @param email String
	 * @return Usuario
	 */
	private Usuario getbyEmail(Node root,String email){
		if (root == null)
		{
			return null;
		}
		else if (email.compareTo(root.getData().getEmail()) < 0)
		{
			return getbyName(root.getLeft(), email);
		}
		else if (email.compareTo(root.getData().getEmail()) > 0)
		{
			return getbyName(root.getRight(), email);
		}
		else
		{
			return root.getData();
		}

	}

	/***
	 * Facade method of the true 'getbyNombre' method.
	 * @param nombre String
	 * @return Usuario
	 */
	public Usuario getbyName(String nombre){
		return getbyName(root,nombre);

	}

	/***
	 * This method finds an user by its 'nombre' atribute.
	 * @param root Node
	 * @param nombre String
	 * @returnUsuario
	 */
	private Usuario getbyName(Node root, String nombre){
		if (root == null)
		{
			return null;
		}
		else if (nombre.compareTo(root.getData().getNombre()) < 0)
		{
			return getbyName(root.getLeft(), nombre);
		}
		else if (nombre.compareTo(root.getData().getNombre()) > 0)
		{
			return getbyName(root.getRight(), nombre);
		}
		else
		{
			return root.getData();
		}

	}

	/***
	 * Facade method of the true 'inorder' method.
	 */
	public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	/***
	 * This method prints the whole users in an in-order pattern.
	 * @param root Node
	 */
	private void inorder(Node root)
	{
		if (root == null)
			return;

		inorder(root.getLeft());
		System.out.print(" " + root.getData());
		inorder(root.getRight());
	}

	/***
	 * Facade method of the true 'preorder' method.
	 */
	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	/***
	 * This method prints the whole users in an pre-order pattern.
	 * @param root Node
	 */
	private void preorder(Node root)
	{
		if (root == null)
			return;

		System.out.print(" " + root.getData());
		preorder(root.getLeft());
		preorder(root.getRight());
	}

	/***
	 * Facade method of the true 'postorder' method.
	 */
	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	/***
	 * This method prints the whole users in an post-order pattern.
	 * @param root Node
	 */
	private void postorder(Node root)
	{
		if (root == null)
			return;

		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(" " + root.getData());
	}

}
