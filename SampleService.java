@Controller
@Produces("application/json")
@Path("sample")
public class SampleService {

    @GET
    @Path("some_path")
    public Sample getSample(@QueryParam("id") String id) throws Exception{
        String hql = " from Sample as s where s.id = '"+id+"'";
        List<Sample> Samples = baseFacade.createQuery(Sample.class,hql,new ArrayList<Object>()).getResultList();
        if(Samples!=null && !Samples.isEmpty()){
            return Samples.get(0);
        }else{
            throw new Exception("ERROR");
        }
    }
}
