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
        <div>
          <strong>{props.title}</strong>
          <Link
            key={index}
            to={'/detail'}
            state={{ image: props?.image, title: props?.title }}
          >
            <MovieImg src={props.image} alt="1" />
          </Link>
        </div>
      ),
    })
  );
  // const MovieCarousel: CarouselItem[] = Array(8)
  //   .fill('')
  //   .map((props: string, index: number) => ({
  //     alt: 'A random photo',
  //     image: `https://picsum.photos/${210 + index}`,
  //     content: (
  //       <div>
  //         <strong>Round Carousel</strong>
  //         <span>Slide number {index + 1}</span>
  //       </div>
  //     ),
  //   }));

  return (
    <>
      <MainWrapper>
        <MainTopText>Lorem ipsum</MainTopText>
        <MovieListWrapper>
          {/* {movie?.map((props, idx) => (
            <Link
              key={idx}
              to={'/detail'}
              state={{ image: props?.image, title: props?.title }}
            >
              <MovieImg src={props.image} alt="1" />
            </Link>
          ))} */}
        </MovieListWrapper>
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

const MovieImg = styled.img`
  width: 200px;
  height: 400px;
`;
