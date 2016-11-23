package rest;

/**
 * @Path( "pop" ) public class FunkoPopWs { //static FunkoPopService service =
 * new FunkoPopService();
 * 
 * @Inject FunkoPopService service;
 * 
 * 
 *         // READ ALL
 * @GET @Produces( MediaType.APPLICATION_JSON )
 * 
 *      public List<FunkoPop> getAll()
 * 
 *      {
 * 
 *      return service.findAll();
 * 
 *      } // READ ONE : path /pop/IDENTIFIANT
 * @GET
 * 
 * 		@Path( "{id}" )
 * 
 * 		@Produces( MediaType.APPLICATION_JSON )
 * 
 *      public FunkoPop getOne( @PathParam( "id" ) int id )
 * 
 *      {
 * 
 *      return service.findFunkoPopById( id );
 * 
 *      } // CREATE @PUT
 * 
 * 		@Consumes( MediaType.APPLICATION_JSON )
 * 
 * 		@Produces( MediaType.APPLICATION_JSON )
 * 
 *      public FunkoPop create( FunkoPop pop )
 * 
 *      {
 * 
 *      return service.createOrUpdate( pop );
 * 
 *      } // UPDATE @POST
 * 
 * 		@Consumes( MediaType.APPLICATION_JSON )
 * 
 * 		@Produces( MediaType.APPLICATION_JSON )
 * 
 *      public FunkoPop update( FunkoPop pop )
 * 
 *      {
 * 
 *      return service.createOrUpdate( pop );
 * 
 *      } // DELETE @DELETE
 * 
 * 		@Path( "{id}" )
 * 
 *      public void delete( @PathParam( "id" ) int id )
 * 
 *      {
 * 
 *      service.delete( id );
 * 
 *      } @Path( "search" )
 * 
 * @GET
 * 
 * 		@Produces( MediaType.APPLICATION_JSON )
 * 
 *      public List<FunkoPop> search( @QueryParam( "name" ) String
 *      name, @QueryParam( "universe" ) String universe )
 * 
 *      {
 * 
 *      return service.search( name, universe );
 * 
 *      } @Path( "urgence" )
 * 
 * @GET
 * 
 * 		@Produces( MediaType.APPLICATION_JSON )
 * 
 *      public List<FunkoPop> getFunkoPopsToShelter()
 * 
 *      {
 * 
 *      return service.getFunkoPopsToShelter();
 * 
 *      } @Path( "travelTime" )
 * 
 * @GET
 * 
 * 		@Produces( MediaType.APPLICATION_JSON )
 * 
 *      public int getTravelTime( @QueryParam( "from" ) int
 *      fromFunkoPopId, @QueryParam( "to" ) int toFunkoPopId )
 * 
 *      {
 * 
 *      return service.getTravelTime( fromFunkoPopId, toFunkoPopId );
 * 
 *      }
 * 
 *      }
 */
