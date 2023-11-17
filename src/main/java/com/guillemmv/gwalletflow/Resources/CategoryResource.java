package com.guillemmv.gwalletflow.Resources;

import com.guillemmv.gwalletflow.Entities.Category;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author GuillemBSK
 */

@Path("/categories")
@Transactional
public class CategoryResource {
    
    @GET
    public Response getAll(){
        List<Category> categories = Category.listAll();
        
        if(!categories.isEmpty()){
            return Response.ok(categories).build();
        }else{
            return Response.status(404).entity("There are no entries!").build();
        }
    }
    
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id){
        Category wantedCategory = Category.findById(id);
        
        if(wantedCategory!=null){
            return Response.ok(wantedCategory).build();
        }else{
            return Response.status(404).entity("There are no entries for with that id!").build();
        }        
    }
    
    @POST
    public Category addNew(Category category){
        category.persist();
        return category;
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id){
        Category expenseToDelete = Category.findById(id);
        
        if(expenseToDelete!=null){
            Category.deleteById(id);
            return Response.ok(expenseToDelete).build();
        }else{
            return Response.status(404).entity("This category does not exist!").build();
        }
    }
}
