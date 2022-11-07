import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useEffect, useState } from 'react';

const Main = () => {
  const [movie, setMovie] = useState([]);
  useEffect(() => {
    fetch('/mvi/box')
      .then(res => res.json())
      .then(data => setMovie(data));
  }, []);

  return (
    <MainWrapper>
      <MainTopText>Lorem ipsum</MainTopText>
      <MovieListWrapper>
        {movie?.map((props, idx) => (
          <Link
            key={idx}
            to={'/detail'}
            state={{ image: props?.image, title: props?.title }}
          >
            <MovieImg src={props.image} alt="1" />
          </Link>
        ))}
      </MovieListWrapper>
    </MainWrapper>
  );
};

export default Main;

const MainWrapper = styled.section`
  width: 100%;
`;

const MainTopText = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 7vh;
  font-size: 1.3rem;
  font-weight: 600;
`;

const MovieListWrapper = styled.div`
  width: 100%;
  height: 80vh;
  border: 1px solid black;
`;

const MovieImg = styled.img`
  width: 200px;
  height: 400px;
`;
