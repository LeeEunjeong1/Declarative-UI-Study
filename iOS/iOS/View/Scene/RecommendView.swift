//
//  RecommendView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct RecommendView: View {
	private let gridData: [(String, String)] = [("grid1", "신학기특가"), ("grid2", "럭셔리"), ("grid3", "뷰티"), ("grid4", "스포츠"), ("grid5", "아울렛"), ("grid6", "키즈"), ("grid7", "골프"), ("grid8", "어스"), ("grid9", "여행패션"), ("grid10", "패션톡")]
	private let imgData: [String] = ["grid1", "grid2", "grid3", "grid4", "grid5", "grid6", "grid7", "grid8", "grid9", "grid10"]
	private let txtData: [String] = ["신학기특가", "럭셔리", "뷰티", "스포츠", "아울렛", "키즈", "골프", "어스", "여행패션", "패션톡"]
	
	private var columns: [GridItem] {
		Array(
			repeating: GridItem(
				.flexible(),
				spacing: 16
			),
			count: 5
		)
	}
	
    var body: some View {
        GeometryReader { proxy in
            ScrollView {
                CarouselView()
                    .frame(height: proxy.size.width)
                LazyVGrid(columns: columns, content: {
                    ForEach((0..<10), id: \.self) { i in
                        VStack {
                            Rectangle()
                                .fill(Color("lightGray"))
                                .frame(height: (proxy.size.width - 16 * 6) / 5)
                                .overlay {
                                    Image(imgData[i])
                                        .resizable()
                                        .aspectRatio(contentMode: .fit)
                                }
                                .clipShape(RoundedRectangle(cornerRadius: 10))
                            Text(txtData[i])
                                .lineLimit(1)
                        }
                    }
                }).padding(16)
                Text("무신사 라이브 편성표")
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.horizontal, 16)
                    .padding(.top, 30)
                    .font(.title2)
                    .bold()
                Text("패션 라이브 쇼핑도 무신사랑")
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.horizontal, 16)
                    .padding(.vertical, 1)
                    .font(.title3)
                HorizontalScrollView()
                    .padding(16)
            }
		}
    }
}

struct RecommendView_Previews: PreviewProvider {
    static var previews: some View {
        RecommendView()
    }
}
