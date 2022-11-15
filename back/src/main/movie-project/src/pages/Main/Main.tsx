import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useEffect, useState } from 'react';
import { Carousel, CarouselItem } from 'react-round-carousel';
import 'react-round-carousel/src/index.css';
import { Carousel as ThreeCarousel } from '3d-react-carousal';

interface MovieData {
  postLink: string;
  title: string;
  rating: string;
}

type postData = {
  postLink: string;
};

const Main = () => {
  const [movie, setMovie] = useState([]);

  useEffect(() => {
    fetch('/mvi/box')
      .then(res => res.json())
      .then(data => {
        setMovie(data);
        console.log(movie);
      });
  }, []);

  const threeCarousel = movie?.map((props: postData, index) => (
    <img src={props.postLink} key={index} />
  ));
  const movieTest: CarouselItem[] = movie?.map(
    (props: MovieData, index: number) => ({
      alt: 'movie poster',
      image: props.postLink,
      content: (
        <Link
          key={index}
          to={'/detail'}
          state={{ image: props?.postLink, title: props?.title }}
        >
          <MovieTitle>{props.title}</MovieTitle>
          <MovieTitle>{props.rating}</MovieTitle>
        </Link>
      ),
    })
  );

  return (
    <>
      <MainWrapper>
        <MainTopText>이번주 Best 영화</MainTopText>
        <MovieListWrapper>
          <ThreeCarousel slides={threeCarousel} autoplay={false} />
        </MovieListWrapper>
      </MainWrapper>
      <QuizWrapper>
        <MainTopText>요즘 인기있는 영화 퀴즈</MainTopText>
        <QuizImgWrapper>
          {movie.slice(0, 6).map((props: postData, idx) => (
            <img src={props.postLink} key={idx} />
          ))}
        </QuizImgWrapper>
      </QuizWrapper>
      <CarouselWrapper>
        <MainTopText>이번주 상영하는 영화</MainTopText>
        <Carousel items={movieTest} itemWidth={500} />
      </CarouselWrapper>
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
  color: #03af59;
`;

const MovieListWrapper = styled.div`
  width: 100%;
  height: 40vh;
  * {
    box-shadow: none !important;
  }

  div div div div div div {
    border: 1px solid white !important;
    border-radius: 50%;
  }

  img {
    width: 25rem;
    height: 30rem;
  }
`;

const MovieTitle = styled.strong`
  width: 100%;
  margin: auto;
`;

const CarouselWrapper = styled.section`
  width: 100%;
  height: 50vh;
`;

const QuizWrapper = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 50vh;
  margin-top: 10rem;
`;

const QuizImgWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  img {
    width: 10%;
    height: 100%;
    padding-right: 0.5rem;
  }
`;
