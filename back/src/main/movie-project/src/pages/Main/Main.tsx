import styled from 'styled-components';
import { useEffect } from 'react';

const Main = () => {
  useEffect(() => {
    fetch('/mvi/search?query="세얼간이"')
      .then(res => res.json())
      .then(data => console.log(data));
  }, []);

  return (
    <MainWrapper>
      <MainTopText>Lorem ipsum</MainTopText>
      <MovieListWrapper>
        {/* <Card width={'10rem'} height={'13rem'} /> */}
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
