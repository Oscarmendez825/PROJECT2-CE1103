package com.BST;


import com.UsuariosManager.Usuario;

public class BinaryTree {
	private Node root;


	public void insert(Usuario data)
	{

		root = insert(root, data);
	}


	private Node insert(Node root, Usuario data)
	{

		if (root == null)
		{
			return new Node(data);
		}
		// Determine whether to go left or right down the BST.
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

	// Helper method for deletion.
	public void delete(Usuario data)
	{

		root = delete(root, data);
	}

	// Finds a given node, and deletes it.
	private Node delete(Node root, Usuario data)
	{
		// Checks for empty tree.
		if (root == null)
		{
			return null;
		}
		// Recursively traverse the tree down to find the node to be deleted.
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
			// When we hit the bottom of the tree.
			if (root.getLeft() == null && root.getRight() == null)
			{
				return null;
			}
			// If we can only go left.
			else if (root.getRight() == null)
			{
				return root.getLeft();
			}
			// If we can only go right.
			else if (root.getLeft() == null)
			{
				return root.getRight();
			}
			// If the root is deleted, this finds the biggest value in the left
			// subtree and puts in in the root.
			else
			{
				root.setData(findMax(root.getLeft()));
				root.setLeft(delete(root.getLeft(), root.getData()));
			}
		}

		return root;
	}

	// This method assumes root is non-null, since this is only called by
	// delete() on the left subtree, and only when that subtree is non-empty.
	private Usuario findMax(Node root)
	{
		while (root.getRight() != null)
		{
			root = root.getRight();
		}

		return root.getData();
	}

	// Returns true if the value is contained in the BST.
	public boolean contains(Usuario data)
	{

		return contains(root, data);
	}

	// Traverses the tree to determine if a given value in contained within it.
	private boolean contains(Node root, Usuario data)
	{
		// Checks for empty tree.
		if (root == null)
		{
			return false;
		}
		// Recursively moving left or right down the tree.
		else if (data.getEmail().compareTo(root.getData().getEmail()) < 0)
		{
			return contains(root.getLeft(), data);
		}
		else if (data.getEmail().compareTo(root.getData().getEmail()) > 0)
		{
			return contains(root.getRight(), data);
		}
		// Returns true when it finds the value.
		else
		{
			return true;
		}
	}


	public Usuario getbyEmail(String email){
		return getbyEmail(root,email);

	}

	private Usuario getbyEmail(Node root,String email){
		if (root == null)
		{
			return null;
		}
		// Recursively moving left or right down the tree.
		else if (email.compareTo(root.getData().getEmail()) < 0)
		{
			return getbyName(root.getLeft(), email);
		}
		else if (email.compareTo(root.getData().getEmail()) > 0)
		{
			return getbyName(root.getRight(), email);
		}
		// Returns true when it finds the value.
		else
		{
			return root.getData();
		}

	}

	public Usuario getbyName(String nombre){
		return getbyName(root,nombre);

	}


	private Usuario getbyName(Node root, String nombre){
		if (root == null)
		{
			return null;
		}
		// Recursively moving left or right down the tree.
		else if (nombre.compareTo(root.getData().getNombre()) < 0)
		{
			return getbyName(root.getLeft(), nombre);
		}
		else if (nombre.compareTo(root.getData().getNombre()) > 0)
		{
			return getbyName(root.getRight(), nombre);
		}
		// Returns true when it finds the value.
		else
		{
			return root.getData();
		}

	}
	// Helper function that prints the inorder traversal.
	public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	// Inorder: Left, root, right
	private void inorder(Node root)
	{
		if (root == null)
			return;

		inorder(root.getLeft());
		System.out.print(" " + root.getData());
		inorder(root.getRight());
	}

	// Helper function that prints the preorder traversal.
	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	// Preorder: Root, left, right
	private void preorder(Node root)
	{
		if (root == null)
			return;

		System.out.print(" " + root.getData());
		preorder(root.getLeft());
		preorder(root.getRight());
	}

	// Helper function that prints the postorder traversal.
	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	// Postorder: Left, right, root
	private void postorder(Node root)
	{
		if (root == null)
			return;

		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(" " + root.getData());
	}

	// How difficult I found this assignment.
	public static double difficultyRating()
	{
		return 3.0;
	}

	// How many hours I spent on this assignment.
	public static double hoursSpent()
	{
		return 2.0;
	}
}
