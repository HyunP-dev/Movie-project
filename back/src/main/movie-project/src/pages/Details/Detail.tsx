import { useLocation } from 'react-router-dom';
import styled from 'styled-components';

const Detail = () => {
  const location = useLocation();
  const movieTitle = location.state.title.substr(
    3,
    location.state.title.length - 7
  );
  fetch(`/mvi/box/read?name=${movieTitle}`)
    .then(res => res.json())
    .then(data => console.log(data));

  return (
    <div>
      <h1>{movieTitle}</h1>
      <ImageWrapper src={location.state.image} />
    </div>
  );
};

export default Detail;

const ImageWrapper = styled.img`
  width: 200px;
  height: 400px;
`;
