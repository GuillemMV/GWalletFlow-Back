package com.guillemmv.gwalletflow.Resources;

import com.guillemmv.gwalletflow.Entities.Expense;
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

@Path("/expenses")
@Transactional
public class ExpenseResource {
    
    @GET
    public Response getAll(){
        List<Expense> categories = Expense.listAll();
        
        if(!categories.isEmpty()){
            return Response.ok(categories).build();
        }else{
            return Response.status(404).entity("There are no entries!").build();
        }
    }
    
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id){
        Expense wantedExpense = Expense.findById(id);
        
        if(wantedExpense!=null){
            return Response.ok(wantedExpense).build();
        }else{
            return Response.status(404).entity("There are no entries for with that id!").build();
        }        
    }
    
    @POST
    public Expense addNew(Expense expense){
        expense.persist();
        return expense;
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id){
        Expense expenseToDelete = Expense.findById(id);
        
        if(expenseToDelete!=null){
            Expense.deleteById(id);
            return Response.ok(expenseToDelete).build();
        }else{
            return Response.status(404).entity("This expense does not exist!").build();
        }
    }
}
