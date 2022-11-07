import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useEffect, useState } from 'react';
import { Carousel, CarouselItem } from 'react-round-carousel';
import 'react-round-carousel/src/index.css';

const Main = () => {
  const [movie, setMovie] = useState([]);

  useEffect(() => {
    fetch('/mvi/box')
      .then(res => res.json())
      .then(data => setMovie(data));

    console.log(movie);
  }, []);
  const movieTest: CarouselItem[] = movie?.map(
    (props: string, index: number) => ({
      alt: 'movie poster',
      image: props.image,
      content: (
        <Link
          key={index}
          to={'/detail'}
          state={{ image: props?.image, title: props?.title }}
        >
          <MovieTitle>
            {props.title.substr(3, props.title.length - 7)}
          </MovieTitle>
        </Link>
      ),
    })
  );

  return (
    <>
      <MainWrapper>
        <MainTopText>Lorem ipsum</MainTopText>
        <MovieListWrapper />
      </MainWrapper>
      <Carousel items={movieTest} itemWidth={500} />
    </>
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
  height: 30vh;
`;

const MovieTitle = styled.strong`
  width: 100%;
  margin: auto;
`;
