import FormCard from 'components/FormCard/formCard';
import { Link, useParams } from 'react-router-dom';

function Form() {

    const params = useParams(); 
   
    return (
       <FormCard movieId={`${params.movieId}`} />
    )
}
export default Form