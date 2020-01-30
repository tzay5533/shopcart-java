# shopcart-java-springBoot framework
Sprint Boot Notes:
==================
*** Environments:
  1. IDE - Sprint Tool Suite 3.9.11 https://spring.io/tools3/sts
  2. MySQL 
     /usr/local/mysql-8.0.19-macos10.15-x86_64/bin
     > /usr/local/mysql -u root -p
     
  3. pom.xml ( project object model )
     POM stands for Project Object Model. The POM contains information about the project and various configuration 
     detail used by Maven to build the project(s). 

*** File structures:  
com.spring.webapp - main 
com.spring.webapp.controllers - defines URL /categories   /categories/{id} 
com.spring.webapp.repository - extend crudRepository<Category, Integer> 

com.spring.webapp.modules 
    Category class variables: id, name, description, getter/setter
com.spring.webapp.service  - 
    CategoryService
    CategoryServiceImpl - getAll(), findById()

META-INF/resources/jsp directory contains the UI 
     home.jsp
     category-info.jsp
     category-list.jsp
     product-info.jsp
     cart.jsp
     show-cart.jsp
     
*** Adding a page
1. adding localhost:8080/home_plain.jsp
2. define the mapping in Controller - ProductController.java
	@RequestMapping("/home_plain")
	public String getAllPlain(Model model) {

		List<Product> products = productService.getAll();
		model.addAttribute("products", products);

		return "home_plain";

	}
	
*** Add a filed in the database: database, Java module class and jsp file.
1. adding column in database table product
   alter table product add column desc_short varchar(80);
2. adding desc_short to module Product: variable, constructor, getter/setter
	public String getDescShort() {
		return this.desc_short;
	}

	public void setDescShort(String desc_short) {
		this.desc_short = desc_short;
	}
3. modify jsp page to include descShort field
   <li>ShortDesc: <font color="red">${product.descShort }</font></li>

*** Add a database table and associated files.

     
    
References:
* https://grokonez.com/spring-framework/spring-data/springjpa-save-filesimages-mysql-database-lob-annotation
* https://www.concretepage.com/spring-boot/spring-boot-crudrepository-example
MVC (Model-View-Controller):
The model represents a Java object carrying data. The view visualizes the data that the model contains. The controller manages the data flow into model object and updates the view whenever data changes; it keeps view and model separate.
     
